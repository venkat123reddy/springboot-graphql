package com.farmfresh.farmfresh.controller;


import com.farmfresh.farmfresh.models.Order;
import com.farmfresh.farmfresh.models.OrderRequest;
import com.farmfresh.farmfresh.repository.OrderRepository;
import com.farmfresh.farmfresh.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @PostMapping("/create")
    public String createOrder(@RequestBody OrderRequest orderRequest) {
        System.out.println("UI......Hit");
        String id = paymentRepository.save(orderRequest.getPaymentRequest()).getPaymentId();
        System.out.println(id);
        Order order = new Order();
        order.setPaymentId(id);
        order.setProductIds(orderRequest.getProductIds());
        order.setDeliveryType(orderRequest.getDeliveryType());
        order.setUserId(orderRequest.getCustomerId());
        return orderRepository.save(order).getOrderId();
    }

    @GetMapping("/get/{userId}")
    public List<Order> getOrder(@RequestBody String userId) {

        return orderRepository.findAll();
    }

}
