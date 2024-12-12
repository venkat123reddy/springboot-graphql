package com.farmfresh.farmfresh.controller;

import com.farmfresh.farmfresh.models.*;
import com.farmfresh.farmfresh.repository.CustomerRepository;
import com.farmfresh.farmfresh.repository.ProfileRepository;
import com.farmfresh.farmfresh.repository.UserRepository;
import com.farmfresh.farmfresh.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileController {

    @Autowired
    ProfileRepository profileRepository;


    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    VendorRepository vendorRepository;

    @GetMapping("/test")
    public Profile create() {

        profileRepository.save(new Profile("venkata","3","abced","3456"));
        return new Profile("venkata","3","abced","3456");
    }

    @GetMapping("/get/{emailId}")
    public Profile getProfile(String email) {
        return profileRepository.findById(email).get();
    }

    private void createCustomer(Profile profile) {
        Customer customer = new Customer();
        customer.setCustomerEmail(profile.getEmail());
        customer.setCustomerName(profile.getName());
        customer.setAddress(profile.address);
        customer.setPhoneNumber(profile.getPhoneNumber());
        customer.setCustomerId(profile.email);
        customerRepository.save(customer);
    }

    private void createVendor(Profile profile) {

        Vendor vendor = new Vendor();
        vendor.setVendorAddress(profile.address);
        vendor.setVendorName(profile.getName());
        vendor.setVendorEmail(profile.getEmail());
        vendor.setVendorId(profile.email);
        vendor.setVendorPhoneNumber(profile.phoneNumber);
        vendorRepository.save(vendor);

    }
    @PostMapping("/create")
    public Profile create(@RequestBody Profile profile) {
        if(profile.customerType.equals("customer")) {

            createCustomer(profile);


        }
        else {

            createVendor(profile);
        }
       userRepository.save(new User(profile.getEmail(),profile.getPassword(), profile.getCustomerType()));
//        return profileRepository.save(profile);

        return null;

    }

    @PostMapping("/validate")
    public ResponseEntity<UserValidationResponse> userValidation(@RequestBody User user) {

        Optional<User> uservalidation = userRepository
                .findByUserName(user.userName);

        System.out.println("exception......");

        if(uservalidation.isPresent() && uservalidation.get().password.toString().equals(user.password) && uservalidation.get().customerType.equals(user.customerType)) {
            return new ResponseEntity<>(new UserValidationResponse(true,"Success"),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(new UserValidationResponse(false,"Invalid Credentials"),HttpStatus.ACCEPTED);
    }

}

