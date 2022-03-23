package com.itrex.ordersystem.service;

import com.itrex.ordersystem.api.v1.controller.response.ProductResponse;

import java.util.List;

public interface ProductService {

    List<ProductResponse> findAll();

}
