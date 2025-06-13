package com.gevernova.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userOne= User.builder()
                .username("admin")
                .password(passwordEncoder().encode("passwordOne"))
                .roles("ADMIN")
                .build();

        UserDetails userTwo=User.builder()
                .username("user")
                .password(passwordEncoder().encode("passwordTwo"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(userOne,userTwo);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/api/public").permitAll()
                        .requestMatchers("/api/user").hasRole("USER")
                        .requestMatchers("/api/admin").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )//enabling form based login
                .formLogin(form->form.defaultSuccessUrl("/api/private",true))
                .httpBasic(basic->{});//enables basic auth
        return http.build();
    }

}
