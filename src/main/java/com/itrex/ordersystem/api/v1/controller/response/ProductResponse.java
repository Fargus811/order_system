package com.itrex.ordersystem.api.v1.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@AllArgsConstructor
@Builder
@Jacksonized
public class ProductResponse {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;
}
