package com.lab3better.orderhistory.controller.write;

import com.lab3better.orderhistory.controller.DeliveryStatusRequest;
import com.lab3better.orderhistory.database.OrderHistoryRepository;
import com.lab3better.orderhistory.model.OrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/orderhistories")
public class OrderHistoryControllerWrite {

    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    @PostMapping
    public ResponseEntity<OrderHistory> createOrderHistory(@RequestBody OrderHistory orderHistory) {
        try {
            OrderHistory _orderHistory = orderHistoryRepository.save(new OrderHistory(
                    orderHistory.getOrderId(),
                    orderHistory.getCustomerName(),
                    orderHistory.getCourierName(),
                    orderHistory.getDeliveryStatus(),
                    orderHistory.getProductNames(),
                    orderHistory.getTotalPrice()));
            return new ResponseEntity<>(_orderHistory, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderHistory> updateOrderHistory(@PathVariable("id") long id,
                                                           @RequestBody DeliveryStatusRequest deliveryStatusRequest) {
        Optional<OrderHistory> orderHistoryData = orderHistoryRepository.findById(id);

        if (orderHistoryData.isPresent()) {
            OrderHistory orderHistory = orderHistoryData.get();
            try {
                orderHistory.setDeliveryStatus(deliveryStatusRequest.deliveryStatus);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(orderHistoryRepository.save(orderHistory), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
