package com.onlineshop.api;

import com.onlineshop.business.cart.Cart;
import com.onlineshop.business.category.CategoryServiceImpl;
import com.onlineshop.business.lineitem.domain.LineItem;
import com.onlineshop.business.product.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class Home8ShopController {
    @Autowired
    CategoryServiceImpl categoryServiceImpl;
    @Autowired
    ProductServiceImpl productServiceImpl;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("cartCount", Cart.cartList.size());
        return "index";
    }
    @GetMapping({ "/about"})
    public String about(Model model) {
        return "about";
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("categories", categoryServiceImpl.getAllCategories());
        model.addAttribute("products", productServiceImpl.getAllProduct());
        model.addAttribute("cartCount", Cart.cartList.size());
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable UUID id) {
        model.addAttribute("categories", categoryServiceImpl.getAllCategories());
        model.addAttribute("products", productServiceImpl.getAllProductsByCategoryId(id));
        model.addAttribute("cartCount", Cart.cartList.size());
        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable UUID id) {
        model.addAttribute("product", productServiceImpl.getProductById(id).get());
        model.addAttribute("cartCount", Cart.cartList.size());
        model.addAttribute("lineItem", new LineItem());
        return "viewProduct";
    }


}
