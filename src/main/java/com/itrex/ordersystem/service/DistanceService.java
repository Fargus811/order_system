package com.itrex.ordersystem.service;

import com.itrex.ordersystem.repository.entity.CustomerEntity;
import com.itrex.ordersystem.repository.entity.WarehouseDistanceToCustomer;
import com.itrex.ordersystem.repository.entity.WarehouseEntity;

public interface DistanceService {

    WarehouseDistanceToCustomer calculateWarehouseDistanceToCustomer(CustomerEntity customerEntity,
                                                                     WarehouseEntity warehouse);
}
