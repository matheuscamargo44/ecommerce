package com.camargo.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.camargo.ecommerce.model.User;
    public interface UserRepository extends JpaRepository<User,Long> {

    }

