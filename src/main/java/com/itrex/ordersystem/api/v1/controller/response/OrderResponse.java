package com.itrex.ordersystem.api.v1.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderResponse {

    private Long id;

    private CustomerResponse customerResponse;

    private ProductResponse productResponse;

    private WarehouseResponse warehouseResponse;

    private Double distanceInMeters;
}
