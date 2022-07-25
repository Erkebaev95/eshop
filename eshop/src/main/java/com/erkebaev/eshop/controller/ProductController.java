package com.erkebaev.eshop.controller;

import com.erkebaev.eshop.model.Product;
import com.erkebaev.eshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final ProductSergivice productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // List
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("products", productService.list());
        return "products";
    }

    // info
    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "createProduct";
    }

    // Add product
    @GetMapping("/addProduct")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "createProduct";
    }

    @PostMapping("/product/create")
    public String addProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/index";
    }

    // delete
    @GetMapping("deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/index";
    }
}
