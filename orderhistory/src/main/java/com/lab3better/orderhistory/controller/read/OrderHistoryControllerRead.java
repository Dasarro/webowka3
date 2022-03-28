package com.lab3better.orderhistory.controller.read;

import com.lab3better.orderhistory.database.OrderHistoryRepository;
import com.lab3better.orderhistory.model.OrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrderHistoryControllerRead {

    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    @GetMapping("/orderhistories")
    public ResponseEntity<List<OrderHistory>> getAllOrderHistories() {
        try {
            List<OrderHistory> orderHistories = new ArrayList<>(orderHistoryRepository.findAll());

            return new ResponseEntity<>(orderHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/orderhistories/{id}")
    public ResponseEntity<OrderHistory> getOrderHistoryById(@PathVariable("id") long id) {
        Optional<OrderHistory> orderHistoryData = orderHistoryRepository.findById(id);

        if (orderHistoryData.isPresent()) {
            return new ResponseEntity<>(orderHistoryData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
