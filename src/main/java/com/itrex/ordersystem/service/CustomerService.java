package com.itrex.ordersystem.service;

import com.itrex.ordersystem.api.v1.controller.request.CreateCustomerRequest;
import com.itrex.ordersystem.api.v1.controller.response.CustomerResponse;

public interface CustomerService {

    CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest);

}
