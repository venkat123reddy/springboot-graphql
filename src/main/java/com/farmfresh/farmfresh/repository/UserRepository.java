package com.farmfresh.farmfresh.repository;

import com.farmfresh.farmfresh.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository  extends MongoRepository<User,String> {

    Optional<User> findByUserNameAndPassword(String userName, String password);

    Optional<User> findByUserName(String userName);
}
