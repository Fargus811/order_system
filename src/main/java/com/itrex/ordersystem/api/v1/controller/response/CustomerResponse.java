package com.itrex.ordersystem.api.v1.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private Double latitude;

    private Double longitude;
}
