package com.farmfresh.farmfresh.serviceImpl;

import com.farmfresh.farmfresh.models.User;
import com.farmfresh.farmfresh.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public String validate(User user) {
        return "Success";
    }
}
