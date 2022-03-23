package com.itrex.ordersystem.mapper.impl;

import com.itrex.ordersystem.api.v1.controller.response.ProductResponse;
import com.itrex.ordersystem.mapper.ProductMapper;
import com.itrex.ordersystem.repository.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponse responseFromEntity(ProductEntity product) {
        if (product == null) {
            return null;
        }
        return ProductResponse.builder().id(product.getId()).name(product.getName()).build();
    }
}
