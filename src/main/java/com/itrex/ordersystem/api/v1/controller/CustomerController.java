package com.itrex.ordersystem.api.v1.controller;

import com.itrex.ordersystem.api.v1.controller.request.CreateCustomerRequest;
import com.itrex.ordersystem.api.v1.controller.response.CustomerResponse;
import com.itrex.ordersystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
        CustomerResponse customerResponse = customerService.createCustomer(createCustomerRequest);
        return new ResponseEntity(customerResponse, HttpStatus.CREATED);
    }


}

