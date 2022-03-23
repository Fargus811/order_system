package com.itrex.ordersystem.service.impl;

import com.itrex.ordersystem.api.v1.controller.request.CreateOrderRequest;
import com.itrex.ordersystem.api.v1.controller.response.OrderResponse;
import com.itrex.ordersystem.exception.NotFoundException;
import com.itrex.ordersystem.mapper.OrderMapper;
import com.itrex.ordersystem.repository.CustomerRepository;
import com.itrex.ordersystem.repository.OrderRepository;
import com.itrex.ordersystem.repository.ProductRepository;
import com.itrex.ordersystem.repository.WarehouseDistanceToCustomerRepository;
import com.itrex.ordersystem.repository.entity.CustomerEntity;
import com.itrex.ordersystem.repository.entity.OrderEntity;
import com.itrex.ordersystem.repository.entity.ProductEntity;
import com.itrex.ordersystem.repository.entity.WarehouseDistanceToCustomer;
import com.itrex.ordersystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final WarehouseDistanceToCustomerRepository warehouseDistanceToCustomerRepository;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        CustomerEntity customerEntity = customerRepository.findById(createOrderRequest.getCustomerId())
                .orElseThrow(() -> new NotFoundException
                        (String.format("Customer with id =%s not found", createOrderRequest.getCustomerId())));
        ProductEntity productEntity = productRepository.findById(createOrderRequest.getProductId())
                .orElseThrow(() -> new NotFoundException
                        (String.format("Product with id =%s not found", createOrderRequest.getProductId())));
        WarehouseDistanceToCustomer nearestWarehouseDistanceToCustomer = warehouseDistanceToCustomerRepository
                .findFirstByCustomerAndWarehouseProductEntitiesOrderByDistanceAsc(customerEntity, productEntity);

        OrderEntity orderEntity = OrderEntity.builder()
                .customer(customerEntity)
                .warehouse(nearestWarehouseDistanceToCustomer.getWarehouse())
                .productEntity(productEntity)
                .distance(nearestWarehouseDistanceToCustomer.getDistance())
                .build();

        return orderMapper.responseFromEntity(orderRepository.save(orderEntity));
    }

    @Override
    public List<OrderResponse> findAll() {
        return orderRepository.findAll().stream().map(orderMapper::responseFromEntity).collect(Collectors.toList());
    }
}
