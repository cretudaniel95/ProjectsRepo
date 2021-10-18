package com.onlineshop.business.cart;

import com.onlineshop.business.lineitem.domain.LineItem;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static List<LineItem> cartList;
    static{
        cartList = new ArrayList<LineItem>();
    }
}
