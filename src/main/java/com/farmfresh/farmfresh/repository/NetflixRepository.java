package com.farmfresh.farmfresh.repository;

import com.farmfresh.farmfresh.models.Netflix;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NetflixRepository extends MongoRepository<Netflix,String> {
}
