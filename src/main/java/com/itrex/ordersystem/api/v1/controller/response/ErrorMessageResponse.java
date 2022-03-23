package com.itrex.ordersystem.api.v1.controller.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorMessageResponse {

    private String message;
    private List<String> errors;

}
