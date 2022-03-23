package com.itrex.ordersystem.api.v1.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class CreateProductRequest {

    @JsonProperty
    private Long id;

    @JsonProperty
    @NotNull(message = "Field name must not be null")
    @NotEmpty(message = "Field name must not be empty")
    private String name;
}
