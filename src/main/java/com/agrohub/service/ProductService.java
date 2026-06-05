package com.agrohub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.agrohub.entity.Product;
import com.agrohub.exception.ProductNotFoundException;
import com.agrohub.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    
    
    public Product saveProduct(Product product) {
        return repository.save(product);
    }
    
    
    public List<Product> getAllProducts() {
        return repository.findAll();
    }
    
    
    public Product getProductById(Long id) {

        Optional<Product> product = repository.findById(id);

        if(product.isPresent()) {
            return product.get();
        }

        throw new ProductNotFoundException("Product Not Found");
    }

    
    public Product updateProduct(Long id, Product updatedProduct) {

        Optional<Product> existingProduct = repository.findById(id);

        if(existingProduct.isPresent()) {

            Product product = existingProduct.get();

            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());

            return repository.save(product);
        }

        return null;
    }
    
    
    public String deleteProduct(Long id) {

        Optional<Product> existingProduct = repository.findById(id);

        if(existingProduct.isPresent()) {

            repository.deleteById(id);

            return "Product Deleted Successfully";
        }

        return "Product Not Found";
    }
}
