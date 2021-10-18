package com.onlineshop.business.order.domain.dto;

import com.onlineshop.business.adress.domain.Address;
import com.onlineshop.business.lineitem.domain.LineItem;
import com.onlineshop.security.domain.User;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OrderDTO {
    private UUID id;
    private List<LineItem> orderItems;
    private Double totalAmount;
    private Address address;
    private User orderUser;
    private Integer statusID;
}
