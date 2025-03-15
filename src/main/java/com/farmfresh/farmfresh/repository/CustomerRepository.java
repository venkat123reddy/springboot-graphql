package com.farmfresh.farmfresh.repository;

import com.farmfresh.farmfresh.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,String> {
  Customer findByCustomerEmail(String email);
}
