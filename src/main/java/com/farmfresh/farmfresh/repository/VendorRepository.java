package com.farmfresh.farmfresh.repository;

import com.farmfresh.farmfresh.models.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendorRepository extends MongoRepository<Vendor,String> {
}
