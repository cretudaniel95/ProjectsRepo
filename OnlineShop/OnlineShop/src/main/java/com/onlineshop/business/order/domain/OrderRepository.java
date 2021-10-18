package com.onlineshop.business.order.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findAllByOrderUser_Id(UUID id);
    Order getOrderById(UUID id);
}
