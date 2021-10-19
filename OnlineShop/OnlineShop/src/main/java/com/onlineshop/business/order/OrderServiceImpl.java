package com.onlineshop.business.order;

import com.onlineshop.business.adress.domain.Address;
import com.onlineshop.business.adress.domain.AddressRepository;
import com.onlineshop.business.cart.Cart;
import com.onlineshop.business.lineitem.domain.LineItem;
import com.onlineshop.business.lineitem.domain.LineItemRepository;
import com.onlineshop.business.order.domain.Order;
import com.onlineshop.business.order.domain.OrderRepository;
import com.onlineshop.business.orderstatus.domain.OrderStatus;
import com.onlineshop.business.orderstatus.domain.OrderStatusRepository;
import com.onlineshop.security.domain.User;
import com.onlineshop.security.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    LineItemRepository lineItemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;


    @Override
    public void placeOrder(String firstname, String lastName, String firstLineAddress, String secondLineAddress,
                           String postCode, String city, Integer phone, String email, String additional) {
        List<LineItem> orderItems = new ArrayList<LineItem>();
        Cart.cartList.forEach(lineItem1 -> {
            lineItemRepository.save(lineItem1);
            orderItems.add(lineItem1);
        });
        Address address = addressRepository.save(Address.builder()
                .firstName(firstname)
                .lastName(lastName)
                .firstLineAddress(firstLineAddress)
                .secondLineAddress(secondLineAddress)
                .postcode(postCode)
                .city(city)
                .phoneNumber(phone)
                .email(email)
                .additionalInformation(additional)
                .build());
        Order order = Order.builder()
                .orderItems(orderItems)
                .totalAmount(orderItems.stream().mapToDouble(LineItem::getPrice).sum())
                .address(address)
                /** Trebuie vazut cum aduc userul logat, nu emailul din formul de checkout, fara erori... **/
                .orderUser(userRepository.getById(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()))
                .status(orderStatusRepository.getById(1))
                .build();
        address.setOrder(order);
        orderItems.forEach(lineItem2 -> lineItem2.setOrder(order));
        orderRepository.save(order);
    }
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    public Order getOrdersByUserId(UUID id) {
        List<Order> orders = orderRepository.findAllByOrderUser_Id(id);
        return orders.get(orders.size()-1);
    }

    public Order getOrderByID(UUID id){
        return orderRepository.getOrderById(id);
    }

    @Override
    public void updateStatus(UUID id, Integer statusID) {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setId(statusID);
        Order order = orderRepository.getOrderById(id);
        order.setStatus(orderStatus);
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrdersOfTheUser(UUID id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return orderRepository.findAllByOrderUser_Id(user.getId());
    }
}
