package com.itrex.ordersystem.service.impl;

import com.itrex.ordersystem.repository.entity.CustomerEntity;
import com.itrex.ordersystem.repository.entity.WarehouseDistanceToCustomer;
import com.itrex.ordersystem.repository.entity.WarehouseEntity;
import com.itrex.ordersystem.service.DistanceService;
import org.apache.lucene.util.SloppyMath;
import org.springframework.stereotype.Service;

@Service
public class DistanceServiceImpl implements DistanceService {

    @Override
    public WarehouseDistanceToCustomer calculateWarehouseDistanceToCustomer(CustomerEntity customerEntity, WarehouseEntity warehouse) {
        double calculatedDistance = SloppyMath.haversinMeters(customerEntity.getLatitude(),
                customerEntity.getLongitude(), warehouse.getLatitude(), warehouse.getLongitude());
        return WarehouseDistanceToCustomer.builder()
                .customer(customerEntity)
                .warehouse(warehouse)
                .distance(calculatedDistance)
                .build();
    }
}
