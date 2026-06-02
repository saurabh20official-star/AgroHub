package com.agrohub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agrohub.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}