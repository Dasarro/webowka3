package com.lab3better.order.service;

import com.lab3better.order.database.OrderRepository;
import com.lab3better.order.database.ProductRepository;
import com.lab3better.order.exception.NotFoundException;
import com.lab3better.order.model.Delivery;
import com.lab3better.order.model.DeliveryStatus;
import com.lab3better.order.model.Order;
import com.lab3better.order.model.OrderItem;
import org.openapitools.client.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderHistoryService orderHistoryService;

    @Override
    public Order createOrder(String customerName, List<OrderItem> items) {
        var order = orderRepository.save(new Order(customerName, items));
        orderHistoryService.writeHistory(order);
        return order;
    }

    @Override
    public Order updateDelivery(Long id, DeliveryStatus status) throws ApiException {
        var order = orderRepository.findById(id).orElseThrow(NotFoundException::new);
        var delivery = order.getDelivery();
        delivery.setStatus(status);
        orderHistoryService.updateHistory(order, status);
        return orderRepository.save(order);
    }
}
