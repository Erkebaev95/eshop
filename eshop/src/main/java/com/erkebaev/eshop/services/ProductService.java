package com.erkebaev.eshop.services;

import org.springframework.stereotype.Service;
import com.erkebaev.eshop.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product(++ID,"PlayStation 5", "Simple description", 470000, "Astana", "Sam"));
        products.add(new Product(++ID, "Iphone 12", "Simple description", 456000, "Astana", "Arman"));
        products.add(new Product(++ID, "Laptop", "Simple description", 570000, "Astana", "Oleg"));
    }

    public List<Product> list() {
        return products;
    }

    public void saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) return product;
        }
        return null;
    }
}
