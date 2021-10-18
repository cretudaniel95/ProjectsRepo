package com.onlineshop.business.order.domain;

import com.onlineshop.business.adress.domain.Address;
import com.onlineshop.business.lineitem.domain.LineItem;
import com.onlineshop.business.orderstatus.domain.OrderStatus;
import com.onlineshop.security.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@Table(name = "orders")
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LineItem> orderItems;

    @Column
    private Double totalAmount;

    @OneToOne()
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL)
    private User orderUser;

    @ManyToOne(cascade = CascadeType.DETACH)
    private OrderStatus status;
}
