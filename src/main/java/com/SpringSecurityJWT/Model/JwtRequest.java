package com.SpringSecurityJWT.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

/**
 * This class represents a JWT (JSON Web Token) request model.
 * It is used to encapsulate user authentication data, including email and password.
 */
public class JwtRequest {

    /**
     * The email associated with the user for authentication.
     */
    private String email;

    /**
     * The password associated with the user for authentication.
     */
    private String password;
}
