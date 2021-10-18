package com.onlineshop.business.lineitem.domain;

import com.onlineshop.business.order.domain.Order;
import com.onlineshop.business.product.domain.Product;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    private Product product;

    @Column
    private Integer quantity;

    @Column
    private Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;
}
