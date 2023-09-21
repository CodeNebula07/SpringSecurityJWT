package com.SpringSecurityJWT.Config;

import com.SpringSecurityJWT.JWT.JwtAuthEntryPoint;
import com.SpringSecurityJWT.JWT.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthEntryPoint point;

    @Autowired
    private JwtAuthenticationFilter filter;

    /**
     * This method defines a SecurityFilterChain bean that configures security settings for HTTP requests.
     * It disables CSRF protection, sets authentication requirements for specific endpoints, and specifies exception handling.
     * Additionally, it sets the session creation policy to STATELESS, indicating no session management.
     * Finally, it adds the JwtAuthenticationFilter before the UsernamePasswordAuthenticationFilter.
     * @param http HttpSecurity object used for configuring security settings
     * @return SecurityFilterChain bean
     * @throws Exception if there is an issue configuring security
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeRequests()
                .requestMatchers("/test").authenticated()
                .requestMatchers("/auth/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
