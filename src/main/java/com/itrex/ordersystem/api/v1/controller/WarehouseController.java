package com.itrex.ordersystem.api.v1.controller;

import com.itrex.ordersystem.api.v1.controller.response.WarehouseResponse;
import com.itrex.ordersystem.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/warehouse")
@Valid
public class WarehouseController {

    private final WarehouseService warehouseService;

    @GetMapping
    public ResponseEntity<List<WarehouseResponse>> findAll() {
        return new ResponseEntity(warehouseService.findAll(), HttpStatus.OK);
    }
}
