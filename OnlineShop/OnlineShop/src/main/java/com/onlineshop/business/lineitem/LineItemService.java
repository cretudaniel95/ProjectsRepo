package com.onlineshop.business.lineitem;

import com.onlineshop.business.lineitem.domain.LineItem;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface LineItemService {

    LineItem createLineItem(UUID id, Integer quantity);

    void updateLineItem(LineItem lineItem, Integer quantity);

    boolean checkAndReplaceIfCartHasProduct(UUID id, Integer quantity);
}
