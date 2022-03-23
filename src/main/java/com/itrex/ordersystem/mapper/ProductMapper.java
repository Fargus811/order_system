package com.itrex.ordersystem.mapper;

import com.itrex.ordersystem.api.v1.controller.response.ProductResponse;
import com.itrex.ordersystem.repository.entity.ProductEntity;

public interface ProductMapper {

    ProductResponse responseFromEntity(ProductEntity product);

}
