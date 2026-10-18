package com.example.communication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
public class SecurityConfig {
    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Matikan CSRF karena metode PUT/POST/DELETE diblokir default oleh Spring Security jika tanpa token
            .csrf(csrf -> csrf.disable())
            // 2. Izinkan semua request ke API buah tanpa perlu login
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/buah/**").permitAll()
                .anyRequest().authenticated()
            );
            
        return http.build();
    }
}
