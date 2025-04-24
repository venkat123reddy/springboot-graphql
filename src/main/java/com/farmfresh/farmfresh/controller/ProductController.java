package com.farmfresh.farmfresh.controller;

import com.farmfresh.farmfresh.models.Product;
import com.farmfresh.farmfresh.models.ProductRequest;
import com.farmfresh.farmfresh.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        product.setProductCost(((int)(0.1*product1.getCost()))+product1.getCost());
        product.setProductName(product1.getName());
        SimpleDateFormat ft  = new SimpleDateFormat("dd-MM-yyyy");

        String currentDate = ft.format(product1.getExpiryDate());
        product.setProductExpiryDate(currentDate);
        product.setProductQuantity(product1.getQuantity());
        product.setUserId(product1.getUserId());
        product.setProductId(product.getProductName()+System.currentTimeMillis());
        return productRepository.save(product);
    }

    @PutMapping("/update")
    Product updateProduct(@RequestBody Product product)
    {
        return productRepository.save(product);
    }

    @PutMapping("/offer")
    Product updateOffer(@RequestBody Product product)
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
