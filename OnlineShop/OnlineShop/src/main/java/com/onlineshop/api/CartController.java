package com.onlineshop.api;

import com.onlineshop.business.cart.Cart;
import com.onlineshop.business.lineitem.LineItemService;
import com.onlineshop.business.lineitem.domain.LineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class CartController {
    @Autowired
    LineItemService lineItemService;

//    @GetMapping("/addToCart/{id}")
//    public String addToCart(@PathVariable UUID id, @RequestParam("quantity") Integer quantity) {
//        Cart.cartList.add(lineItemService.createLineItem(id, quantity));
//        return "redirect:/shop";
//    }

    @PostMapping("/addToCart/{id}")
    public String addToCartSubmit(@PathVariable UUID id, @RequestParam("quantity") Integer quantity) {
        Cart.cartList.add(lineItemService.createLineItem(id, quantity));
        return "redirect:/shop";
    }

    @GetMapping("/cart")
    public String cartGet(Model model) {
        model.addAttribute("cartCount", Cart.cartList.size());
        model.addAttribute("total", Cart.cartList.stream().mapToDouble(LineItem::getPrice).sum());
        model.addAttribute("cart", Cart.cartList);
        return "cart";
    }

    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index) {
        Cart.cartList.remove(index);
        return "redirect:/cart";
    }

//    @GetMapping("/checkout")
//    public String checkout(Model model) {
//        model.addAttribute("total", Cart.cartList.stream().mapToDouble(LineItem::getPrice).sum());
//        return "checkout";
//    }
//
//    @GetMapping("/orderPlaced")
//    public String orderPlaced() {
//        return "orderPlaced";
//    }
}
