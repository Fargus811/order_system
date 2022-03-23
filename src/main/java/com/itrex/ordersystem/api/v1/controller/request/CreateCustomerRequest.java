package com.itrex.ordersystem.api.v1.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class CreateCustomerRequest {

    @NotBlank(message = "Field first name must not be empty")
    @Size(min = 1, max = 24, message = "First name must be between one and 24 characters")
    @JsonProperty
    private String firstName;

    @NotBlank(message = "Field last name must not be empty")
    @Size(min = 1, max = 24, message = "Last name must be between one and 24 characters")
    @JsonProperty
    private String lastName;

    @JsonProperty
    @NotNull(message = "Field latitude must not be null")
    @DecimalMin(value = "-90", message = "Latitude must be greater or equal -90")
    @DecimalMax(value = "90", message = "Latitude must be lower or equal 90")
    private Double latitude;

    @JsonProperty
    @NotNull(message = "Field longitude must not be null")
    @DecimalMin(value = "-180", message = "Longitude must be greater or equal -180")
    @DecimalMax(value = "180", message = "Longitude must be lower or equal 180")
    private Double longitude;

}
