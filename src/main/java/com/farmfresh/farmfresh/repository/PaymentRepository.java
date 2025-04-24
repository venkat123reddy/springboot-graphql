package com.farmfresh.farmfresh.repository;

import com.farmfresh.farmfresh.models.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment,String> {
}
