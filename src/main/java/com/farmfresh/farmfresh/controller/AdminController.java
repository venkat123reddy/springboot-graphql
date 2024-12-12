package com.farmfresh.farmfresh.controller;

import com.farmfresh.farmfresh.models.AdminSummary;
import com.farmfresh.farmfresh.models.ProdRefData;
import com.farmfresh.farmfresh.models.User;
import com.farmfresh.farmfresh.repository.OrderRepository;
import com.farmfresh.farmfresh.repository.RefDataRepository;
import com.farmfresh.farmfresh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    RefDataRepository refDataRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/summary")
    public AdminSummary getSummary() {
        AdminSummary adminSummary = new AdminSummary();
        adminSummary.setTotalOrders(orderRepository.findAll().size());
        adminSummary.setTotalUsers(userRepository.findAll().size());

        return adminSummary;
    }
    @PostMapping("/add")
    public String addRefData(@RequestBody ProdRefData prodRefData) {
        return refDataRepository.save(prodRefData).getType();
    }

    @GetMapping("/get")
    public List<ProdRefData> getRefData() {
        return refDataRepository.findAll();
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
