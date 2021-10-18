package com.onlineshop.api;

import com.onlineshop.business.category.CategoryServiceImpl;
import com.onlineshop.business.category.domain.Category;
import com.onlineshop.business.order.OrderService;

import com.onlineshop.business.product.ProductServiceImpl;
import com.onlineshop.business.product.domain.Product;
import com.onlineshop.business.product.dto.ProductDTO;
import com.onlineshop.security.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Controller
public class AccountController {


    @Autowired
    OrderService orderService;



    @GetMapping("/myAccount")
    public String getMyOrders(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("orders", orderService.getAllOrdersOfTheUser(user.getId()));
        return "myAccount";
    }

    @GetMapping("/myAccount/{id}")
    public String viewOrderDetails(@PathVariable UUID id,Model model){
        model.addAttribute("order1", orderService.getOrderByID(id));
        return "orderUpdate";
    }
/**
 @GetMapping("/admin/orders/update/{id}") public String updateOrderGet(@PathVariable UUID id, Model model) {
 model.addAttribute("orderStatus", new OrderStatus());
 model.addAttribute("order", orderService.getOrderByID(id));
 model.addAttribute("orderStatuses", orderStatusService.getAllOrderStatuses());
 return "orderUpdate";
 }

 @PostMapping("/admin/orders/update/{id}") public String updateOrderPost(@PathVariable UUID id, @RequestParam("statusID") Integer statusID) {
 orderService.updateStatus(id, statusID);
 return "redirect:/admin/orders";
 }**/
}
