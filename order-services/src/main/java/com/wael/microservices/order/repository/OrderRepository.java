package com.wael.microservices.order.repository;

import com.wael.microservices.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order ,Long> {
}
