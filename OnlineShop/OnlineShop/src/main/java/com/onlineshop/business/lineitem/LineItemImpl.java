package com.onlineshop.business.lineitem;

import com.onlineshop.business.cart.Cart;
import com.onlineshop.business.lineitem.domain.LineItem;
import com.onlineshop.business.product.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LineItemImpl implements LineItemService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public LineItem createLineItem(UUID id, Integer quantity) {
        return LineItem.builder()
                .product(productRepository.getById(id))
                .quantity(quantity)
                .price(productRepository.getById(id).getPrice() * quantity)
                .build();
    }

    @Override
    public void updateLineItem(LineItem lineItem, Integer quantity) {
        Integer tempQuantity = lineItem.getQuantity();
        lineItem.setQuantity(tempQuantity + quantity);
        lineItem.setPrice(lineItem.getProduct().getPrice() * lineItem.getQuantity());
    }

    @Override
    public boolean checkAndReplaceIfCartHasProduct(UUID id, Integer quantity) {
        boolean check = false;
        for (int i = 0; i < Cart.cartList.size(); i++) {
            if (Cart.cartList.get(i).getProduct().getId().equals(id)) {
                updateLineItem(Cart.cartList.get(i), quantity);
                check = true;
            }
        }
        return check;
    }
}
