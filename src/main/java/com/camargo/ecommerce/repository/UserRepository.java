package com.camargo.ecommerce.repository;

import com.camargo.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String email);
}
