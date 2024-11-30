package com.farmfresh.farmfresh.controller;


import com.farmfresh.farmfresh.models.Order;
import com.farmfresh.farmfresh.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @PostMapping("/create")
    public String createOrder(@RequestBody Order order) {
        System.out.println("UI......Hit");
        return orderRepository.save(order).getOrderId();
    }

}
