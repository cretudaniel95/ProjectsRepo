package com.onlineshop.business.product;

import com.onlineshop.business.product.domain.Product;
import com.onlineshop.business.product.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void removeProductsById(UUID id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> getProductById(UUID id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProductsByCategoryId(UUID id) {
        return productRepository.findAllByCategory_Id(id);
    }

}
