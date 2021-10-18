package com.onlineshop.business.lineitem.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LineItemRepository extends JpaRepository<LineItem, UUID> {
}
