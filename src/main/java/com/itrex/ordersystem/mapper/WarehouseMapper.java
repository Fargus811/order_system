package com.itrex.ordersystem.mapper;

import com.itrex.ordersystem.api.v1.controller.response.WarehouseResponse;
import com.itrex.ordersystem.repository.entity.WarehouseEntity;

public interface WarehouseMapper {

    WarehouseResponse responseFromEntity(WarehouseEntity warehouse);

}
