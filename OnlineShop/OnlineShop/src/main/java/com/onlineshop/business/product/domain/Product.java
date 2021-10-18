package com.onlineshop.business.product.domain;

import com.onlineshop.business.category.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private String description;

    @Column
    private String imageName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}