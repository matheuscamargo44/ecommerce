package com.camargo.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.camargo.ecommerce.model.Product;
public interface ProductRepository extends JpaRepository<Product, Long> {

}
