package com.lab3better.order.dto;

import com.lab3better.order.model.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public class CreateOrderRequest {
    public String customerName;
    public List<CreateOrderItemRequest> items;
}
