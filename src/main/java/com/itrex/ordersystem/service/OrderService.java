package com.itrex.ordersystem.service;

import com.itrex.ordersystem.api.v1.controller.request.CreateOrderRequest;
import com.itrex.ordersystem.api.v1.controller.response.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse createOrder(CreateOrderRequest createOrderRequest);

    List<OrderResponse> findAll();
}

