package com.SpringSecurityJWT.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@org.springframework.context.annotation.Configuration
class Configuration {
    /**
     * This method defines a UserDetailsService bean.
     * It creates a UserDetails object for a user 'security' with an encoded password and assigns the 'ADMIN' role to the user.
     * The UserDetails object is then stored in memory using an InMemoryUserDetailsManager.
     * @return UserDetailsService bean
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.builder()
                .username("security")
                .password(passwordEncoder().encode("security"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    /**
     * This method defines a PasswordEncoder bean.
     * It returns a BCryptPasswordEncoder, which is used to securely hash and verify passwords.
     * @return PasswordEncoder bean
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * This method defines an AuthenticationManager bean.
     * It takes an AuthenticationConfiguration as a parameter and retrieves the AuthenticationManager from it.
     * @param builder AuthenticationConfiguration used to obtain the AuthenticationManager
     * @return AuthenticationManager bean
     * @throws Exception if there is an issue obtaining the AuthenticationManager
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
