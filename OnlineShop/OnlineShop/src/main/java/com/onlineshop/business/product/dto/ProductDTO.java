package com.onlineshop.business.product.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductDTO {
    private UUID id;
    private String name;
    private UUID categoryId;
    private Double price;
    private String description;
    private String imageName;
}
