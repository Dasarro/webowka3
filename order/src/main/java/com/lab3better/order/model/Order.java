package com.lab3better.order.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "`ORDER`")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private String customerName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items;

    @OneToOne(cascade = CascadeType.ALL)
    private Delivery delivery;

    public Order(String customerName, List<OrderItem> items) {
        this.customerName = customerName;
        this.items = items;
        this.delivery = new Delivery(DeliveryStatus.Created);
    }
}
