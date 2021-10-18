package com.onlineshop.business.order;

import com.onlineshop.business.order.domain.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public interface OrderService {

    @Transactional(rollbackFor = Exception.class)
    void placeOrder(String firstname, String lastName, String firstLineAddress, String secondLineAddress,
                    String postCode, String city, Integer phone, String email, String additional);

//    Object getAllOrders();

    @Transactional
    List<Order> getAllOrders();

    Order getOrderByID(UUID id);

    void updateStatus(UUID id, Integer statusID);

    List<Order> getAllOrdersOfTheUser(UUID id);
}
