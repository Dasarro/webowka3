package com.lab3better.order.controller;

import com.lab3better.order.database.ProductRepository;
import com.lab3better.order.dto.CreateOrderRequest;
import com.lab3better.order.exception.NotFoundException;
import com.lab3better.order.model.Order;
import com.lab3better.order.model.OrderItem;
import com.lab3better.order.service.OrderService;
import org.openapitools.client.ApiException;
import org.springframework.web.bind.annotation.*;

import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final ProductRepository productRepository;

    public OrderController(OrderService orderService, ProductRepository productRepository) {
        this.orderService = orderService;
        this.productRepository = productRepository;
    }

    @PostMapping
    public Order createOrder(@RequestBody CreateOrderRequest orderRequest) {
        var items = orderRequest.items.stream()
                .map(orderItem -> new OrderItem(productRepository.findById(orderItem.productId).orElseThrow(NotFoundException::new), orderItem.quantity))
                .toList();
        return orderService.createOrder(orderRequest.customerName, items);
    }

    @PutMapping("/{id}/status")
    public Order updateOrder(@PathVariable("id") long id,
                             @RequestBody DeliveryStatusRequest deliveryStatusRequest) throws ApiException {
        return orderService.updateDelivery(id, deliveryStatusRequest.deliveryStatus);
    }
}