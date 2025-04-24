package com.farmfresh.farmfresh.repository;

import com.farmfresh.farmfresh.models.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  OfferRepository extends MongoRepository<Offer,String> {
}
