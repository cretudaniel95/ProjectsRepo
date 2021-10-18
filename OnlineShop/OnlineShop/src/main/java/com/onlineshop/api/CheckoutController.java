package com.onlineshop.api;

import com.onlineshop.business.cart.Cart;
import com.onlineshop.business.lineitem.domain.LineItem;
import com.onlineshop.business.order.OrderService;
import com.onlineshop.business.order.OrderServiceImpl;
import com.onlineshop.security.domain.User;
import com.onlineshop.security.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckoutController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderServiceImpl orderServiceImpl;

    @Autowired
    UserRepository userRepository;



    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("total", Cart.cartList.stream().mapToDouble(LineItem::getPrice).sum());
        return "checkout";
    }

    @PostMapping("/checkout")
    public String placeOrder(@RequestParam ("firstName") String firstname,
                             @RequestParam ("lastName") String lastName,
                             @RequestParam ("firstLineAddress") String firstLineAddress,
                             @RequestParam ("secondLineAddress") String secondLineAddress,
                             @RequestParam ("postcode") String postCode,
                             @RequestParam ("city") String city,
                             @RequestParam ("phoneNumber") Integer phone,
                             @RequestParam ("email") String email,
                             @RequestParam ("additionalInformation") String additional) {
        orderService.placeOrder(firstname, lastName, firstLineAddress, secondLineAddress, postCode, city, phone,email, additional);
        Cart.cartList.clear();
        return "redirect:/orderPlaced";
    }

    @GetMapping("/orderPlaced")
    public String orderPlaced(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("order1", orderServiceImpl.getOrdersByUserId(user.getId()));
        return "orderPlaced";
    }
}
