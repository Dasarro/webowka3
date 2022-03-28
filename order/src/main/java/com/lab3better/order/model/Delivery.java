package com.lab3better.order.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    private String courierName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus status;

    public Delivery(DeliveryStatus status) {
        this.status = status;
    }
}
