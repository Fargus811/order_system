package com.itrex.ordersystem.mapper.impl;

import com.itrex.ordersystem.api.v1.controller.request.CreateCustomerRequest;
import com.itrex.ordersystem.api.v1.controller.response.CustomerResponse;
import com.itrex.ordersystem.mapper.CustomerMapper;
import com.itrex.ordersystem.repository.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerEntity requestToEntity(CreateCustomerRequest source) {
        if (source == null) {
            return null;
        }
        return CustomerEntity.builder()
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .latitude(source.getLatitude())
                .longitude(source.getLongitude())
                .build();
    }

    @Override
    public CustomerResponse responseFromEntity(CustomerEntity source) {
        if (source == null) {
            return null;
        }
        return CustomerResponse.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .latitude(source.getLatitude())
                .longitude(source.getLongitude())
                .build();
    }
}
