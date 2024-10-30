package com.farmfresh.farmfresh.serviceImpl;

import com.farmfresh.farmfresh.models.Profile;
import com.farmfresh.farmfresh.models.User;
import com.farmfresh.farmfresh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public String validate(User user) {
        return "Success";
    }

    @Override
    public Profile getUserDetails(User user) {
        log.info("service layer");
        return new Profile("venkata","123e","reddy@gmail.com","7036008925");
    }
}
