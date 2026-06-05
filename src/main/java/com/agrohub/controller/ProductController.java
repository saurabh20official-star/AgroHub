package com.agrohub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.agrohub.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.agrohub.entity.Product;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/test")
    public String test() {
        return "Product Controller Working";
    }
    
    
    @PostMapping("/products")
    public Product saveProduct(@Valid @RequestBody Product product) {

        return productService.saveProduct(product);
    }
    
    
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    
    
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {

        return productService.getProductById(id);
    }
    
    
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product product) {

        return productService.updateProduct(id, product);
    }
    
    
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id) {

        return productService.deleteProduct(id);
    }
}







