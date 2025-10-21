package com.camargo.ecommerce.service;

import com.camargo.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Override
public UserDetails loadUserByUsername(String email)
    throws UsernameNotFoundException {
    // Busca o usuário por email.
    User user = userRepository
        .findByEmail(email)
        // Se não encontrar, lança a exceção.
        .orElseThrow(() ->
            new UsernameNotFoundException(
                "Usuário não encontrado com email: " + email
            )
        );

    return new org.springframework.security.core.userdetails.User(
        user.getEmail(),
        user.getPassword(),
        new ArrayList<>()
    );
}
