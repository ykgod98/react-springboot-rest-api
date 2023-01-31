package com.example.gccoffee.controller;

import com.example.gccoffee.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String productPage(Model model) {
        var products = productService.getAllProducts();
        System.out.println(products);
        return "product-list";
    }

    @GetMapping("new-product")
    public String newProductPage() {
        return "new-product";
    }

    @PostMapping("/products")
    public String newProducts(CreateProductRequest createProductRequest) {
        productService.createProduct(createProductRequest.productName(), createProductRequest.category(), createProductRequest.price(), createProductRequest.description());
        return "redirect:/products";
    }


}
