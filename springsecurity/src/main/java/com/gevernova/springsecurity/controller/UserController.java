package com.gevernova.springsecurity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/user")
    public String UserApi(){
        return "Hello user!";
    }
    @GetMapping("/admin")
    public String adminApi(){
        return "Hello Admin!";
    }
    @GetMapping("/public")
    public String publicApi(){
        return "Public api";
    }
}
