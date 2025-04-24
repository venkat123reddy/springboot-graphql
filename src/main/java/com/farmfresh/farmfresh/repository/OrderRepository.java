package com.farmfresh.farmfresh.repository;

import com.farmfresh.farmfresh.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,String> {
}
