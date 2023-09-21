# **Spring Boot 3.0 InMemory User and JWT Authentication**

This repository demonstrates how to configure **InMemory user** and **JWT (JSON Web Token) authentication** using **Spring Boot 3.0**. We will create a protected endpoint and secure it using **Spring Boot Security**.

## **Getting Started**

Follow these steps to set up and configure your **Spring Boot** project.

### **Create a New Spring Boot Project**

1. Visit the [**Spring Initializer**](https://start.spring.io/) website.
2. Create a new project with the following dependencies:

   - **Web**
   - **Security**
   - **Lombok (Optional)**
   - **JWT**

### **Create a Protected Endpoint**

Create a REST controller with a protected endpoint:

```java
@RestController
public class HomeController {
    // Your controller code here
}
```

## **Configure InMemory User with UserDetailsService**

Create a `**UserDetailsService**` bean and implement **InMemory user** authentication. Define a `**PasswordEncoder**` and an `**AuthenticationManager**` bean in a custom configuration class.

## **Usage**

You can now log in using the provided **username** and **password**. **Spring Security** provides a default form login.

## **JWT Authentication Flow**

Follow these steps to implement **JWT token authentication**:

1. Ensure that `**spring-boot-starter-security**` is included in your `**pom.xml**`.

2. Create a class `**JWTAthenticationEntryPoint**` that implements `**AuthenticationEntryPoint**`. This class handles exceptions thrown when an unauthenticated user tries to access a resource that requires authentication.

3. Create a `**JwtHelper**` class that contains methods related to JWT token operations such as generating and validating tokens.

4. Create a `**JwtAuthenticationFilter**` that extends `**OncePerRequestFilter**`. This filter checks the token in the request header and sets the authentication if the token is valid.

5. Configure **Spring Security** in a configuration file, specifying the security filter chain and exception handling.

6. Create `**JWTRequest**` and `**JWTResponse**` classes to handle request data and send login success responses.

7. Implement a login API that accepts a username and password and returns a JWT token if the credentials are correct.

8. Test the application.

**Note:** This README provides an overview of the steps involved in setting up **InMemory user** and **JWT authentication** in a **Spring Boot 3.0** application. For a detailed understanding, refer to the code and comments in the project files.
