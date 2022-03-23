package com.itrex.ordersystem.service.impl;

import com.itrex.ordersystem.api.v1.controller.request.CreateCustomerRequest;
import com.itrex.ordersystem.api.v1.controller.response.CustomerResponse;
import com.itrex.ordersystem.mapper.CustomerMapper;
import com.itrex.ordersystem.repository.CustomerRepository;
import com.itrex.ordersystem.repository.WarehouseRepository;
import com.itrex.ordersystem.repository.entity.CustomerEntity;
import com.itrex.ordersystem.repository.entity.WarehouseDistanceToCustomer;
import com.itrex.ordersystem.service.CustomerService;
import com.itrex.ordersystem.service.DistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final DistanceService distanceService;
    private final CustomerRepository customerRepository;
    private final WarehouseRepository warehouseRepository;

    @Override
    @Transactional
    public CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {
        CustomerEntity customerEntity = customerMapper.requestToEntity(createCustomerRequest);
        Set<WarehouseDistanceToCustomer> warehouseDistancesToCustomer = new HashSet<>();
        warehouseRepository.findAll().parallelStream().forEach((warehouse ->
                warehouseDistancesToCustomer.add(distanceService.calculateWarehouseDistanceToCustomer(customerEntity, warehouse))));
        customerEntity.setWarehouseDistanceToCustomers(warehouseDistancesToCustomer);
        return customerMapper.responseFromEntity(customerRepository.save(customerEntity));
    }
}
