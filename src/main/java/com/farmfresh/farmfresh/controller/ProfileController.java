package com.farmfresh.farmfresh.controller;

import com.farmfresh.farmfresh.models.Profile;
import com.farmfresh.farmfresh.models.User;
import com.farmfresh.farmfresh.models.UserValidationResponse;
import com.farmfresh.farmfresh.repository.ProfileRepository;
import com.farmfresh.farmfresh.repository.UserRepository;
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

    @GetMapping("/test")
    public Profile create() {

        profileRepository.save(new Profile("venkata","3","abced","3456"));
        return new Profile("venkata","3","abced","3456");
    }

    @PostMapping("/create")
    public Profile create(@RequestBody Profile profile) {
        System.out.println("create");
        profile.id = profile.email;
        userRepository.save(new User(profile.getEmail(),profile.getPassword()));
        return profileRepository.save(profile);

    }

    @PostMapping("/validate")
    public ResponseEntity<UserValidationResponse> userValidation(@RequestBody User user) {

        Optional<User> uservalidation = userRepository.findByUserNameAndPassword(user.userName,user.password);

        if(uservalidation.isPresent()) {
            return new ResponseEntity<>(new UserValidationResponse(true,"Success"),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(new UserValidationResponse(false,"Invalid Credentials"),HttpStatus.ACCEPTED);
    }

}

