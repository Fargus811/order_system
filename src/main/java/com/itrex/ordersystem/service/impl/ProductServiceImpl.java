package com.itrex.ordersystem.service.impl;

import com.itrex.ordersystem.api.v1.controller.response.ProductResponse;
import com.itrex.ordersystem.mapper.ProductMapper;
import com.itrex.ordersystem.repository.ProductRepository;
import com.itrex.ordersystem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream().map(productMapper::responseFromEntity).collect(Collectors.toList());
    }
}
