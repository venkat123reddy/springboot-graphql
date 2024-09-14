package com.farmfresh.farmfresh.service;

import com.farmfresh.farmfresh.models.Profile;
import com.farmfresh.farmfresh.models.User;

public interface UserService {

    String validate(User user);
    Profile getUserDetails(User user);
}
