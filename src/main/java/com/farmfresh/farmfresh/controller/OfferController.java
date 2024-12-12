package com.farmfresh.farmfresh.controller;

import com.farmfresh.farmfresh.models.Offer;
import com.farmfresh.farmfresh.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offer")
@CrossOrigin(origins = "http://localhost:4200")
public class OfferController {

    @Autowired
    OfferRepository offerRepository;

    @GetMapping("/get")
    public List<Offer> offersList() {
        return offerRepository.findAll();
    }

    @PostMapping("/create")
    public String updateOffers(@RequestBody Offer offer) {
        return offerRepository.save(offer).getProductId();
    }

}
