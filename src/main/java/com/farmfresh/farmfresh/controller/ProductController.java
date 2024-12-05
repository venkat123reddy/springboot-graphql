package com.farmfresh.farmfresh.controller;

import com.farmfresh.farmfresh.models.Product;
import com.farmfresh.farmfresh.models.ProductRequest;
import com.farmfresh.farmfresh.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/create")
    Product createProduct(@RequestBody ProductRequest product1) {

        Product product = new Product();

        System.out.println(product1.getUserId());

        product.setProductCost(product1.getCost());
        product.setProductName(product1.getName());
        product.setProductExpiryDate(product1.getExpiryDate());
        product.setProductQuantity(product1.getQuantity());
        product.setUserId(product1.getUserId());

        return productRepository.save(product);
    }

    @PutMapping("/update")
    Product updateProduct(@RequestBody Product product)
    {
        return productRepository.save(product);
    }

    @GetMapping("/get")
    List<Product> getProducts() {
        return productRepository.findAll();
    }
    @GetMapping("/get/{userId}")
    List<Product> getProducts(@PathVariable  String userId) {
        return productRepository.findByUserId(userId);
    }
}
