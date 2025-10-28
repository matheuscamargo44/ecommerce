package com.camargo.ecommerce.service;

import com.camargo.ecommerce.model.User;
import com.camargo.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Busca o usuário por email
        User user = userRepository
            .findByEmail(email)
            // Se não encontrar, lança a exceção
            .orElseThrow(() -> 
                new UsernameNotFoundException("Usuário não encontrado com email: " + email)
            );

        return new org.springframework.security.core.userdetails.User(
            user.getEmail(),
            user.getPassword(),
            new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority("ROLE_" + user.getRole())))
        );
    }

    // Métodos adicionais que você pode implementar
    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}