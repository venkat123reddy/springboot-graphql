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

    public static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Encrypt uppercase letters
            if (Character.isUpperCase(ch)) {
                ch = (char) (((int) ch + shift - 65) % 26 + 65);
            }
            // Encrypt lowercase letters
            else if (Character.isLowerCase(ch)) {
                ch = (char) (((int) ch + shift - 97) % 26 + 97);
            }

            encryptedText.append(ch);
        }

        return encryptedText.toString();
    }

    // Decrypts the given string using Caesar cipher
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);  // Reverse the shift to decrypt
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
    public ProfileResponse create(@RequestBody Profile profile) {

        profile.password = ProfileController.encrypt(profile.password,3);
        if (userRepository.findByUserName(profile.email).isPresent()) {
           return new ProfileResponse(300,"Email  already");
        }
        if(profile.customerType.equals("customer")) {

            createCustomer(profile);


        }
        else {

            createVendor(profile);
        }
        User user = new User();
        user.setPassword(profile.password);
        user.setCustomerType(profile.getCustomerType());
        user.setUserName(profile.getEmail());
        user.setLoginCount(0);
       userRepository.save(user);
        return new ProfileResponse(200,"created");

    }
    @PostMapping("/password")
    public String updatePasswROD(@RequestBody User user) {
        User users = userRepository.findByUserName(user.userName).get();
        users.setPassword(users.password);
        userRepository.save(users);
        return "password updated successfully";

    }

    @PostMapping("/validate")
    public ResponseEntity<UserValidationResponse> userValidation(@RequestBody User user) {

        Optional<User> uservalidation = userRepository
                .findByUserName(user.userName);

     String dec = ProfileController.encrypt(user.password,3);

        System.out.println("exception......");

        if(uservalidation.isPresent() && uservalidation.get().password.toString().equals(dec) && uservalidation.get().customerType.equals(user.customerType)) {
            int count =  uservalidation.get().loginCount;
            uservalidation.get().setLoginCount(count+1);
            userRepository.save(uservalidation.get());
            String address = null;
            if(user.customerType.equals("customer")) {
                address = customerRepository.findByCustomerEmail(user.userName).getAddress();
            }


            return new ResponseEntity<>(new UserValidationResponse(true,"Success",count,address),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(new UserValidationResponse(false,"Invalid Credentials",0,""),HttpStatus.ACCEPTED);
    }
    @PostMapping("/block/{userName}")
    public String block(@PathVariable String userName) {
        Optional<User> uservalidation = userRepository
                .findByUserName(userName);
        uservalidation.get().setPassword("awwss");
        userRepository.save(uservalidation.get());
        return "block";

    }

}

