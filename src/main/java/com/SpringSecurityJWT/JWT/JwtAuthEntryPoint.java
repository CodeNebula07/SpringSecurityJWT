package com.SpringSecurityJWT.JWT;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {

    /**
     * This class acts as an AuthenticationEntryPoint for JWT authentication.
     * It is responsible for handling unauthorized access attempts.
     * When an unauthorized access is detected, it sets the HTTP response status to 401 (Unauthorized)
     * and sends an error message to the client.
     *
     * @param request       HttpServletRequest object representing the incoming request
     * @param response      HttpServletResponse object representing the outgoing response
     * @param authException AuthenticationException representing the authentication error
     * @throws IOException      if there is an issue with input/output operations
     * @throws ServletException if there is an issue with the servlet handling
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // Set HTTP response status to 401 (Unauthorized)
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // Get a PrintWriter to send an error message to the client
        PrintWriter writer = response.getWriter();

        // Write an error message to the response
        writer.println("Access Denied !! " + authException.getMessage());
    }
}
