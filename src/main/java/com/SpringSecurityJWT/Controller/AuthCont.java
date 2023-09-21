package com.SpringSecurityJWT.Controller;

import com.SpringSecurityJWT.JWT.JwtHelper;
import com.SpringSecurityJWT.Model.JwtRequest;
import com.SpringSecurityJWT.Model.JwtResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthCont {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(AuthCont.class);

    /**
     * This endpoint handles user authentication and generates a JWT token upon successful authentication.
     * It takes a JwtRequest object containing user email and password as input.
     * If the authentication is successful, it returns a ResponseEntity with a JwtResponse containing the JWT token.
     * @param request JwtRequest object containing user email and password
     * @return ResponseEntity with JwtResponse and HTTP status
     */
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
        // Authenticate the user
        this.doAuthenticate(request.getEmail(), request.getPassword());

        // Load user details
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        // Generate JWT token
        String token = this.helper.generateToken(userDetails);

        // Create JwtResponse and return it in ResponseEntity
        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .userName(userDetails.getUsername())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * This private method performs user authentication using Spring Security's AuthenticationManager.
     * It takes user email and password as input, creates an authentication token, and attempts authentication.
     * If authentication fails due to bad credentials, it throws a BadCredentialsException.
     * @param email User email
     * @param password User password
     */
    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid Username or Password!!");
        }
    }

    /**
     * This method handles exceptions of type BadCredentialsException.
     * It returns a message indicating that the credentials are invalid.
     * @return Error message for invalid credentials
     */
    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid!!";
    }
}
