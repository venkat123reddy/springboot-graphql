package com.farmfresh.farmfresh.controller;


import com.farmfresh.farmfresh.models.Order;
import com.farmfresh.farmfresh.models.OrderRequest;
import com.farmfresh.farmfresh.models.OrderStatus;
import com.farmfresh.farmfresh.models.Product;
import com.farmfresh.farmfresh.repository.OrderRepository;
import com.farmfresh.farmfresh.repository.PaymentRepository;
import com.farmfresh.farmfresh.repository.ProductRepository;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    ProductRepository productRepository;



    @PostMapping("/accept/{orderId}")
    public String acceptOrder(@PathVariable String orderId ) {

        Order order = orderRepository.findById(orderId).get();
        order.setOrderStatus(OrderStatus.accepted.name());
        orderRepository.save(order);
        return "order Accepted";
    }

    @PostMapping("/cancel/{orderId}")
    public String CancelOrder(@PathVariable String orderId) {

        Order order = orderRepository.findById(orderId).get();
        order
                .getProductBillList()
                        .stream()
                                .map(productBill -> {
                                    Product product = productRepository.findById(productBill.getProductId()).get();
                                    product.setProductQuantity(product.getProductQuantity()+productBill.getProductCount());
                                    productRepository.save(product);
                                    return product;
                                });
        order.setOrderStatus(OrderStatus.cancelled.name());
        orderRepository.save(order);
        return "Order Cancelled";
    }

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
        order.setOrderStatus(OrderStatus.created.name());
        order.setProductBillList(orderRequest.getProductbiils());
        order.setOrderName(orderRequest.getProductbiils().get(0).getProductName());
        SimpleDateFormat ft  = new SimpleDateFormat("dd-MM-yyyy");

        String currentDate = ft.format(new Date());
        order.setOrderCreatedDate(currentDate);
        //order.setOrderId(orderRequest.getProductbiils().get(0).getProductId()+System.currentTimeMillis());
        List<Product> productList =
        orderRequest.
                getProductbiils()
                .stream()
                .map(productbill -> {
                    Product product = productRepository.findById(productbill.getProductId()).get();
                    product.setProductQuantity(product.getProductQuantity()-productbill.getProductCount());
                    productRepository.save(product);
                    return product;})
                .toList();

        

        return orderRepository.save(order).getOrderId();
    }

    @GetMapping("/get/{userId}")
    public List<Order> getOrder(@PathVariable String userId) {

        return orderRepository.findAll()
                .stream()
                .filter(order -> order.getUserId().equals(userId))
                .toList();
    }

    @GetMapping("/get/all")
    public List<Order> getOrders() {

        return orderRepository.findAll();
    }


    @GetMapping("/get/customer/{userId}")
    public List<Order> getOrderCustomer(@PathVariable String userId) {

        List<String> productids = productRepository
                .findByUserId(userId)
                .stream().map(Product::getProductId)
                .toList();

        System.out.println(productids);

        return orderRepository.findAll()
                .stream()
                .filter(order ->
                        !order.getProductIds().stream()
                                .filter(productids::contains)
                                .toList().isEmpty())
                .toList();
    }

}

