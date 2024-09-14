package com.farmfresh.farmfresh.serviceImpl;

import com.farmfresh.farmfresh.models.Profile;
import com.farmfresh.farmfresh.models.User;
import com.farmfresh.farmfresh.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public String validate(User user) {
        return "Success";
    }

    @Override
    public Profile getUserDetails(User user) {
        return new Profile("venkata","123e","reddy@gmail.com","7036008925");
    }
}
