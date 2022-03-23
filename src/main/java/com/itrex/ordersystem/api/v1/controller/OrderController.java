package com.itrex.ordersystem.api.v1.controller;

import com.itrex.ordersystem.api.v1.controller.request.CreateOrderRequest;
import com.itrex.ordersystem.api.v1.controller.response.OrderResponse;
import com.itrex.ordersystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/order")
@Valid
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        return new ResponseEntity(orderService.createOrder(createOrderRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll() {
        return new ResponseEntity(orderService.findAll(), HttpStatus.OK);
    }
}
