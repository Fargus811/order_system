package com.itrex.ordersystem.mapper;

import com.itrex.ordersystem.api.v1.controller.request.CreateCustomerRequest;
import com.itrex.ordersystem.api.v1.controller.response.CustomerResponse;
import com.itrex.ordersystem.repository.entity.CustomerEntity;

public interface CustomerMapper {

    CustomerEntity requestToEntity(CreateCustomerRequest source);

    CustomerResponse responseFromEntity(CustomerEntity source);
}
