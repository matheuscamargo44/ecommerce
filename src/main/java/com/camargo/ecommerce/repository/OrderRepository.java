package com.camargo.ecommerce.repository;

import com.camargo.ecommerce.model.Order;
import com.camargo.ecommerce.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}
