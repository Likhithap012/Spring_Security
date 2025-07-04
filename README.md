
# Spring Security

This is a basic Spring Boot application demonstrating **Spring Security** using an **in-memory user store**, **role-based authorization**, **form login**, and **basic authentication**.

---

##  Technologies Used

- Java 17+
- Spring Boot
- Spring Security
- Maven

---

##  Features

- In-memory authentication with BCrypt password encoding
- Two users:
  - `admin` with role `ADMIN`
  - `user` with role `USER`
- Role-based access control
- Form login and HTTP Basic authentication
- CSRF disabled for simplicity (can be enabled in production)


---

## Running the Application

1. **Clone the repo**
   ```bash
   git clone https://github.com/your-username/springsecurity-prac.git
   cd springsecurity-prac


2. **Build and Run**

   ```bash
   mvn spring-boot:run
   ```

3. **Test APIs** (default port: `8080`)

---
## 📡 API Endpoints

| Endpoint       | Method | Access Role   | Description                |
| -------------- | ------ | ------------- | -------------------------- |
| `/api/public`  | GET    | Public        | No authentication required |
| `/api/user`    | GET    | USER          | Requires USER role         |
| `/api/admin`   | GET    | ADMIN         | Requires ADMIN role        |
| `/api/private` | GET    | Authenticated | Redirect after login       |




