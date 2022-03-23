package com.itrex.ordersystem.service;

import com.itrex.ordersystem.api.v1.controller.response.WarehouseResponse;

import java.util.List;

public interface WarehouseService {

    List<WarehouseResponse> findAll();
}
