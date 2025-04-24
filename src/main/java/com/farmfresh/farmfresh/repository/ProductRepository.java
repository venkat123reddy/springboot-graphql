package com.farmfresh.farmfresh.repository;

import com.farmfresh.farmfresh.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {
 List<Product> findByUserId(String userId);
}
