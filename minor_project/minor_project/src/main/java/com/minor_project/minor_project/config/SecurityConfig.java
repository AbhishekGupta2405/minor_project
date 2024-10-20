package com.minor_project.minor_project.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .requireCsrfProtectionMatcher(request -> {
                            // Customize matcher logic as needed
                            return !request.getServletPath().startsWith("/api/auth/");
                        })
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/auth/login", "/api/auth/register").permitAll() // Allow public access
                        .anyRequest().authenticated() // Require authentication for all other requests
                );

        return http.build();
    }

}
