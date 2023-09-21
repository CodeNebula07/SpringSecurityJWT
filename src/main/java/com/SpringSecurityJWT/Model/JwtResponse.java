package com.SpringSecurityJWT.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

/**
 * This class represents a JWT (JSON Web Token) response model.
 * It is used to encapsulate the JWT token and the username associated with a successful authentication response.
 */
public class JwtResponse {

    /**
     * The JWT token generated upon successful authentication.
     */
    private String jwtToken;

    /**
     * The username associated with the authenticated user.
     */
    private String userName;
}
