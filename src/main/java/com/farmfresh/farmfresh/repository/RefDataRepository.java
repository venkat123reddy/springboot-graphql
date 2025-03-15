package com.farmfresh.farmfresh.repository;

import com.farmfresh.farmfresh.models.ProdRefData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RefDataRepository extends MongoRepository<ProdRefData,String> {
  ProdRefData findByName(String name);
}
