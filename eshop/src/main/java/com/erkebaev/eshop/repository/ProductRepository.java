package com.erkebaev.eshop.repository;

import java.util.List;
import com.erkebaev.eshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);
}
