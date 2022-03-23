package com.itrex.ordersystem.api.v1.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class CreateOrderRequest {

    @JsonProperty
    @NotNull(message = "Field customerId must not be null")
    private Long customerId;

    @JsonProperty
    @NotNull(message = "Field productId must not be null")
    private Long productId;

}
