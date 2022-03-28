package com.lab3better.order.service;

import com.lab3better.order.model.Delivery;
import com.lab3better.order.model.DeliveryStatus;
import com.lab3better.order.model.Order;
import com.lab3better.order.model.OrderItem;
import org.openapitools.client.ApiException;

import java.util.List;

public interface OrderService {
    Order createOrder(String customerName, List<OrderItem> items);
    Order updateDelivery(Long id, DeliveryStatus status) throws ApiException;
}
