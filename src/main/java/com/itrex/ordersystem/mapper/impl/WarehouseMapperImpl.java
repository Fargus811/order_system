package com.itrex.ordersystem.mapper.impl;

import com.itrex.ordersystem.api.v1.controller.response.WarehouseResponse;
import com.itrex.ordersystem.mapper.ProductMapper;
import com.itrex.ordersystem.mapper.WarehouseMapper;
import com.itrex.ordersystem.repository.entity.WarehouseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class WarehouseMapperImpl implements WarehouseMapper {

    private final ProductMapper productMapper;

    @Override
    public WarehouseResponse responseFromEntity(WarehouseEntity warehouse) {
        if (warehouse == null) {
            return null;
        }
        return WarehouseResponse.builder()
                .id(warehouse.getId())
                .name(warehouse.getName())
                .productResponses(warehouse.getProductEntities().stream().map(productMapper::responseFromEntity)
                        .collect(Collectors.toSet()))
                .build();
    }
}
