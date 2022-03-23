package com.itrex.ordersystem.api.v1.controller.handler;

import com.itrex.ordersystem.api.v1.controller.response.ErrorMessageResponse;
import com.itrex.ordersystem.exception.NotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final String NOT_FOUND_ENTITY_MESSAGE = "Not found entity";
    private static final String INVALID_DATA_ERROR = "Invalid data, please correct errors and try again.";

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorMessageResponse> handleNotFoundException(NotFoundException ex) {
        List<String> errorMessages = Collections.singletonList(ex.getMessage());
        return new ResponseEntity<>(ErrorMessageResponse.builder()
                .message(NOT_FOUND_ENTITY_MESSAGE)
                .errors(errorMessages).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorMessageResponse> handleArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<String> errorMessages = result.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return new ResponseEntity<>(ErrorMessageResponse.builder()
                .message(INVALID_DATA_ERROR)
                .errors(errorMessages).build(), HttpStatus.BAD_REQUEST);
    }
}
