package com.farmfresh.farmfresh.repository;

import com.farmfresh.farmfresh.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
