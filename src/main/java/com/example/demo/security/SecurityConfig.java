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
            .requestMatchers("/home").authenticated()
            .requestMatchers("h2/**").permitAll()
            .requestMatchers("/admin/veterinario").authenticated()
            .requestMatchers("/admin/agregar").authenticated()
            .requestMatchers("/admin/veterinario/**").authenticated()
            .requestMatchers("/admin/estado/**").authenticated()
            .requestMatchers("/admin/actualizar/veterinario").authenticated()
            .requestMatchers("/admin/delete/**").authenticated()
            .requestMatchers("/admin/veterinario/activos").authenticated()
            .requestMatchers("/admin/veterinario/inactivos").authenticated()
            .requestMatchers("/admin/veterinario/activos/count").authenticated()
            .requestMatchers("/admin/veterinario/inactivos/count").authenticated()
            .requestMatchers("/admin/login").permitAll()
            .requestMatchers("/cliente/lista").authenticated()
            .requestMatchers("/cliente/misgatos/**").authenticated()
            .requestMatchers("/cliente/usuario/**").authenticated()
            .requestMatchers("/cliente/delete/**").authenticated()
            .requestMatchers("/cliente/update/**").authenticated()
            .requestMatchers("/cliente/cedula").permitAll()
            .requestMatchers("/tratamiento/realizados").authenticated()
            .requestMatchers("/tratamiento/por_droga").authenticated()
            .requestMatchers("/tratamiento/veterinario/**").authenticated()
            .requestMatchers("/tratamiento/gato/**").authenticated()
            .requestMatchers("/tratamiento/informacion/veterinario/**").authenticated()
            .requestMatchers("/tratamiento/informacion/gato/**").authenticated()
            .requestMatchers("/tratamiento/agregar").authenticated()
            .requestMatchers("/mascota/lista").authenticated()
            .requestMatchers("/mascota/activos").authenticated()
            .requestMatchers("/mascota/total").authenticated()
            .requestMatchers("mascsota/estado/**").authenticated()
            .requestMatchers("/mascota/gato/**").authenticated()
            .requestMatchers("/mascota/agregar").authenticated()
            .requestMatchers("/mascota/delete/**").authenticated()
            .requestMatchers("/mascota/update/**").authenticated()
            .requestMatchers("/droga/todas").authenticated()
            .requestMatchers("/droga/nombre").authenticated()
            .requestMatchers("/droga/ventas_totales").authenticated()
            .requestMatchers("/droga/ganancias").authenticated()
            .requestMatchers("/droga/nombre/**").authenticated()
            .requestMatchers("/droga/actualizar/**").authenticated()
            .anyRequest().permitAll()
            ); 
        return http.build();
    }
}
