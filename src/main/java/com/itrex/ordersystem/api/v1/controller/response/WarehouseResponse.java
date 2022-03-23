package com.itrex.ordersystem.api.v1.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@Jacksonized
public class WarehouseResponse {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private Double latitude;

    @JsonProperty
    private Double longitude;

    @JsonProperty
    private Set<ProductResponse> productResponses;
}
