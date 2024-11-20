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
                            String path = request.getServletPath();
                            return !(path.startsWith("/api/worker/") || path.startsWith("/api/auth/")||path.startsWith("/api/appointments/"));
                        })
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/auth/login", "/api/auth/register","/api/worker/save","/api/worker/all","/api/worker/{id}","/api/appointments/save","/api/appointments/all","/api/appointments/{id}").permitAll() // Allow public access
                        .anyRequest().authenticated() // Require authentication for all other requests
                );

        return http.build();
    }

}
