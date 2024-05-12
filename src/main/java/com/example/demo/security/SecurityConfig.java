package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean 
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        http.
            csrf(AbstractHttpConfigurer::disable)
            .headers(headers -> headers.frameOptions(frame -> frame.disable()))
            .authorizeHttpRequests(requests -> requests
            .requestMatchers("h2/**").permitAll()
            .requestMatchers("/admin/veterinario").authenticated()
            .requestMatchers("/admin/agregar").authenticated()
            .requestMatchers("/admin/veterinario/**").authenticated()
            .requestMatchers("/admin/estado/**").authenticated()
            .requestMatchers("/admin/actualizar/veterinario").authenticated()
            .requestMatchers("/admin/delete/**").authenticated()
            .requestMatchers("/admin/login").permitAll()
            .anyRequest().permitAll()
            ); 
        return http.build();
    }
}
