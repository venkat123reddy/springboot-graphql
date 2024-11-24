package com.farmfresh.farmfresh.repository;

import com.farmfresh.farmfresh.models.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile,String> {
}
