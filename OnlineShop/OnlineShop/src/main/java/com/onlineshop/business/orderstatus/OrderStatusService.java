package com.onlineshop.business.orderstatus;

import com.onlineshop.business.orderstatus.domain.OrderStatus;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
public interface OrderStatusService {

    @Transactional
    List<OrderStatus> getAllOrderStatuses();
}
