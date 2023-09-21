package com.SpringSecurityJWT.Service;

import com.SpringSecurityJWT.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * This class represents a service for managing user data.
 * It provides a list of sample users and a method to retrieve them.
 */
@org.springframework.stereotype.Service
public class Service {

    /**
     * List to store sample user data.
     */
    private List<User> store = new ArrayList<User>();

    /**
     * Constructor to initialize the service with sample user data.
     * The sample users are added to the 'store' list.
     */
    public Service() {
        store.add(new User(UUID.randomUUID().toString(), "abc", "abc@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(), "xyz", "xyz@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(), "mno", "mno@gmail.com"));
    }

    /**
     * Retrieves a list of users.
     *
     * @return List of User objects
     */
    public List<User> getUsers() {
        return this.store;
    }
}
