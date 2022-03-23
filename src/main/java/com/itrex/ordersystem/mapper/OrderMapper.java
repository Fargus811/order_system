package com.itrex.ordersystem.mapper;

import com.itrex.ordersystem.api.v1.controller.response.OrderResponse;
import com.itrex.ordersystem.repository.entity.OrderEntity;

public interface OrderMapper {

    OrderResponse responseFromEntity(OrderEntity orderEntity);

}
