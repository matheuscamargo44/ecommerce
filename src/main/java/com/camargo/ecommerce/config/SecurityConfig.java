package com.camargo.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        // Desabilita o CSRF, APIs REST usam tokens (como JWT) para segurança, e não dependem de cookies de sessão para prevenir ataques.
        .csrf(csrf -> csrf.disable())

        // Define a API como stateless (sem estado), usando apenas tokens
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

        // Define as regras de autorização para os endpoints
        .authorizeHttpRequests(authorize -> authorize
            // Permite acesso irrestrito para todas as requisições GET em /api/products.
            .requestMatchers("/api/products").permitAll()
            .requestMatchers("/api/products/*").permitAll()
            .requestMatchers("/api/users/register").permitAll()
            .requestMatchers("/api/users/login").permitAll()

            .requestMatchers(HttpMethod.POST, "/api/products").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/api/products/*").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/api/products/*").hasRole("ADMIN")

            // O que sobrar (se houver outro endpoint)
            .anyRequest().authenticated()
        );

        // Retorna o objeto de configuração montado
        return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Retorna a implementação BCrypt, que é o padrão seguro para senhas.
        return new BCryptPasswordEncoder();
    }
}
