package com.lab3better.orderhistory.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderHistory {

    @Id
    private Long orderId;

    private String customerName;

    private String courierName;

    private String deliveryStatus;

    private String productNames;

    private BigDecimal totalPrice;

    public OrderHistory(Long orderId, String customerName, String courierName, String deliveryStatus, String productNames, BigDecimal totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.courierName = courierName;
        this.deliveryStatus = deliveryStatus;
        this.productNames = productNames;
        this.totalPrice = totalPrice;
    }
}
