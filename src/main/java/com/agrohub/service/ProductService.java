package com.agrohub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrohub.entity.Product;
import com.agrohub.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

}
