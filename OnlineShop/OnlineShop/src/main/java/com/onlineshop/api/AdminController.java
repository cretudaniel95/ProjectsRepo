package com.onlineshop.api;

import com.onlineshop.business.category.CategoryServiceImpl;
import com.onlineshop.business.category.domain.Category;
import com.onlineshop.business.order.OrderService;

import com.onlineshop.business.order.domain.Order;
import com.onlineshop.business.order.domain.dto.OrderDTO;
import com.onlineshop.business.orderstatus.OrderStatusService;
import com.onlineshop.business.orderstatus.domain.OrderStatus;
import com.onlineshop.business.product.ProductServiceImpl;
import com.onlineshop.business.product.domain.Product;
import com.onlineshop.business.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AdminController {
    private static String uploadDir = "src/main/resources/static/productImages";

    @Autowired
    CategoryServiceImpl categoryServiceImpl;

    @Autowired
    ProductServiceImpl productServiceImpl;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderStatusService orderStatusService;

    //Category

    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryServiceImpl.getAllCategories());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCategoryAdd(Model model) {
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCategoryAdd(@ModelAttribute("category") Category category) {
        categoryServiceImpl.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable UUID id) {
        categoryServiceImpl.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCategory(@PathVariable UUID id, Model model) {
        Optional<Category> category = categoryServiceImpl.getCategoryById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        } else {
            return "404 Error. Category not found.";
        }
    }

    //Product

    @GetMapping("admin/products")
    public String products(Model model) {
        model.addAttribute("products", productServiceImpl.getAllProduct());
        return "products";
    }

    @GetMapping("admin/products/add")
    public String productAddGet(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categories", categoryServiceImpl.getAllCategories());
        return "productsAdd";
    }

    @PostMapping("admin/products/add")
    public String productAddPost(@ModelAttribute("productDTO") ProductDTO productDTO,
                                 @RequestParam("productImage") MultipartFile file,
                                 @RequestParam("imgName") String imgName) throws IOException {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryServiceImpl.getCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        String imageUUID;
        if (!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path filenameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(filenameAndPath, file.getBytes());
        } else {
            imageUUID = imgName;
        }
        product.setImageName(imageUUID);
        productServiceImpl.addProduct(product);

        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable UUID id) {
        productServiceImpl.removeProductsById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProductGet(@PathVariable UUID id, Model model) {
        Product product = productServiceImpl.getProductById(id).get();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageName(product.getImageName());

        model.addAttribute("categories", categoryServiceImpl.getAllCategories());
        model.addAttribute("productDTO", productDTO);

        return "productsAdd";
    }

    //Orders

    @GetMapping("/admin/orders")
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders";
    }

    @GetMapping("/admin/orders/update/{id}")
    public String updateOrderGet(@PathVariable UUID id, Model model) {
        model.addAttribute("orderStatus", new OrderStatus());
        model.addAttribute("order1", orderService.getOrderByID(id));
        model.addAttribute("orderStatuses", orderStatusService.getAllOrderStatuses());
        return "orderUpdate";
    }

    @PostMapping ("/admin/orders/update/{id}/{statusId}")
    public String updateOrderPost(@PathVariable UUID id,  @PathVariable("statusId") String statusID){
        orderService.updateStatus(id, Integer.valueOf(statusID));
        return "redirect:/admin/orders";
    }
}
