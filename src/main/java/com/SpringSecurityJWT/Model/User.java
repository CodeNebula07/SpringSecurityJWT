package com.SpringSecurityJWT.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

/**
 * This class represents a User model.
 * It encapsulates user information, including user ID, username, and email.
 */
public class User {

    /**
     * The unique identifier for the user.
     */
    private String userId;

    /**
     * The username associated with the user.
     */
    private String userName;

    /**
     * The email address of the user.
     */
    private String email;
}
