package com.itrex.ordersystem.service.impl;

import com.itrex.ordersystem.api.v1.controller.response.WarehouseResponse;
import com.itrex.ordersystem.mapper.WarehouseMapper;
import com.itrex.ordersystem.repository.WarehouseRepository;
import com.itrex.ordersystem.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseMapper warehouseMapper;
    private final WarehouseRepository warehouseRepository;

    @Override
    public List<WarehouseResponse> findAll() {
        return warehouseRepository.findAll().stream()
                .map(warehouseMapper::responseFromEntity).collect(Collectors.toList());
    }
}
