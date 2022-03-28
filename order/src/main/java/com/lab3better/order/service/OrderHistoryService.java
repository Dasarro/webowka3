package com.lab3better.order.service;

import com.lab3better.order.model.DeliveryStatus;
import com.lab3better.order.model.Order;
import org.openapitools.client.ApiException;
import org.springframework.stereotype.Service;

public interface OrderHistoryService {
    void writeHistory(Order order);
    void updateHistory(Order order, DeliveryStatus status) throws ApiException;
}
