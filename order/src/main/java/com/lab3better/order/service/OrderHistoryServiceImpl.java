package com.lab3better.order.service;

import com.lab3better.order.model.DeliveryStatus;
import com.lab3better.order.model.Order;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.OrderHistoryControllerWriteApi;
import org.openapitools.client.model.DeliveryStatusRequest;
import org.openapitools.client.model.OrderHistory;
import org.springframework.stereotype.Service;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {
    private final OrderHistoryControllerWriteApi api = new OrderHistoryControllerWriteApi();

    @Override
    public void writeHistory(Order order) {
        var orderHistory = new OrderHistory();
        orderHistory.setOrderId(order.getId());
        try {
            api.createOrderHistory(orderHistory);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateHistory(Order order, DeliveryStatus status) throws ApiException {
        var deliveryStatusRequest = new DeliveryStatusRequest();
        deliveryStatusRequest.setDeliveryStatus(status.name());
        api.updateOrderHistory(order.getId(), deliveryStatusRequest);
    }
}
