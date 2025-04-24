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
        ProdRefData prodRefData1 = refDataRepository.findByName(prodRefData.getName());
        if(prodRefData1==null) {
            return refDataRepository.save(prodRefData).getType();
        }
        return "Duplicate";
    }

    @GetMapping("/get")
    public List<String> getRefData() {
        return refDataRepository.findAll()
                .stream().map(ProdRefData::getName)
                .toList();
    }

    @GetMapping("/gets")
    public List<ProdRefData> getRefDatas() {
        return refDataRepository.findAll();
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
