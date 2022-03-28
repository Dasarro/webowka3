package com.lab3better.orderhistory.database;

import com.lab3better.orderhistory.model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
}
