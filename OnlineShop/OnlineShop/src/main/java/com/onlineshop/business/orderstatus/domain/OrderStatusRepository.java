package com.onlineshop.business.orderstatus.domain;

import com.onlineshop.business.orderstatus.domain.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {

}