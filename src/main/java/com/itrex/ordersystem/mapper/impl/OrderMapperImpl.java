package com.itrex.ordersystem.mapper.impl;

import com.itrex.ordersystem.api.v1.controller.response.OrderResponse;
import com.itrex.ordersystem.mapper.CustomerMapper;
import com.itrex.ordersystem.mapper.OrderMapper;
import com.itrex.ordersystem.mapper.ProductMapper;
import com.itrex.ordersystem.mapper.WarehouseMapper;
import com.itrex.ordersystem.repository.entity.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapperImpl implements OrderMapper {

    private final ProductMapper productMapper;
    private final WarehouseMapper warehouseMapper;
    private final CustomerMapper customerMapper;

    @Override
    public OrderResponse responseFromEntity(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        return OrderResponse.builder()
                .id(orderEntity.getId())
                .customerResponse(customerMapper.responseFromEntity(orderEntity.getCustomer()))
                .productResponse(productMapper.responseFromEntity(orderEntity.getProductEntity()))
                .warehouseResponse(warehouseMapper.responseFromEntity(orderEntity.getWarehouse()))
                .distanceInMeters(orderEntity.getDistance())
                .build();
    }
}
