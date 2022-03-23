package com.itrex.ordersystem.api.v1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrex.ordersystem.api.v1.controller.request.CreateCustomerRequest;
import com.itrex.ordersystem.api.v1.controller.request.CreateOrderRequest;
import com.itrex.ordersystem.api.v1.controller.response.CustomerResponse;
import com.itrex.ordersystem.api.v1.controller.response.OrderResponse;
import com.itrex.ordersystem.repository.CustomerRepository;
import com.itrex.ordersystem.repository.ProductRepository;
import com.itrex.ordersystem.repository.entity.CustomerEntity;
import com.itrex.ordersystem.repository.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest
@AutoConfigureMockMvc
class MvcControllersTest {

    private static final String CUSTOMER_CONTROLLER_URL = "/api/v1/customer";
    private static final String ORDER_CONTROLLER_URL = "/api/v1/order";

    private static final String TEST_CUSTOMER_FIRST_NAME = "John";
    private static final String TEST_CUSTOMER_LAST_NAME = "Harrington";
    private static final double TEST_DOUBLE_VALUE = 10;

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void createCustomer_shouldCreateCustomer() throws Exception {
        // given
        CreateCustomerRequest createCustomerDto = createCustomerDto();

        // when
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.post(CUSTOMER_CONTROLLER_URL)
                                .accept(APPLICATION_JSON_VALUE)
                                .contentType(APPLICATION_JSON_VALUE)
                                .content(mapper.writeValueAsString(createCustomerDto)))
                .andReturn();

        // then
        MockHttpServletResponse response = mvcResult.getResponse();
        CustomerResponse createdCustomer = mapper.readValue(response.getContentAsString(), CustomerResponse.class);

        assertAll(() -> assertEquals(HttpStatus.CREATED.value(), response.getStatus()),
                () -> assertNotNull(response.getContentAsString()),
                () -> assertNotNull(createdCustomer.getId()),
                () -> assertNotNull(createdCustomer.getFirstName()),
                () -> assertNotNull(createdCustomer.getLastName()),
                () -> assertNotNull(createdCustomer.getLongitude()),
                () -> assertNotNull(createdCustomer.getLatitude()));
    }

    @Test
    void createCustomer_shouldNotCreateInvalidCustomer() throws Exception {
        // given
        CreateCustomerRequest invalidCreateCustomerRequest = CreateCustomerRequest.builder().build();

        // when
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.post(CUSTOMER_CONTROLLER_URL)
                                .accept(APPLICATION_JSON_VALUE)
                                .contentType(APPLICATION_JSON_VALUE)
                                .content(mapper.writeValueAsString(invalidCreateCustomerRequest)))
                .andReturn();

        // then
        MockHttpServletResponse response = mvcResult.getResponse();
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }

    private CreateCustomerRequest createCustomerDto() {
        return CreateCustomerRequest.builder()
                .firstName(TEST_CUSTOMER_FIRST_NAME)
                .lastName(TEST_CUSTOMER_LAST_NAME)
                .latitude(TEST_DOUBLE_VALUE)
                .longitude(TEST_DOUBLE_VALUE)
                .build();
    }

    @Test
    void createOrder_shouldCreateOrder() throws Exception {
        // given
        ProductEntity product = productRepository.findById(1L).orElseThrow();
        CreateCustomerRequest createCustomerRequest = createCustomerDto();
        MvcResult createCustomer = mockMvc.perform(
                        MockMvcRequestBuilders.post(CUSTOMER_CONTROLLER_URL)
                                .accept(APPLICATION_JSON_VALUE)
                                .contentType(APPLICATION_JSON_VALUE)
                                .content(mapper.writeValueAsString(createCustomerRequest)))
                .andReturn();
        CustomerResponse createdCustomer = mapper.readValue(createCustomer.getResponse().getContentAsString(),
                CustomerResponse.class);
        CreateOrderRequest createOrder = CreateOrderRequest.builder()
                .customerId(createdCustomer.getId())
                .productId(product.getId())
                .build();

        // when
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.post(ORDER_CONTROLLER_URL)
                                .accept(APPLICATION_JSON_VALUE)
                                .contentType(APPLICATION_JSON_VALUE)
                                .content(mapper.writeValueAsString(createOrder)))
                .andReturn();

        // then
        MockHttpServletResponse response = mvcResult.getResponse();
        OrderResponse orderResponse = mapper.readValue(response.getContentAsString(), OrderResponse.class);

        assertAll(() -> assertEquals(HttpStatus.CREATED.value(), response.getStatus()),
                () -> assertNotNull(response.getContentAsString()),
                () -> assertNotNull(orderResponse.getId()),
                () -> assertNotNull(orderResponse.getDistanceInMeters()),
                () -> assertNotNull(orderResponse.getWarehouseResponse()),
                () -> assertNotNull(orderResponse.getWarehouseResponse().getLatitude()),
                () -> assertNotNull(orderResponse.getWarehouseResponse().getLongitude()),
                () -> assertNotNull(orderResponse.getProductResponse()),
                () -> assertEquals(product.getId(), orderResponse.getProductResponse().getId()));
    }

    @Test
    void createOrder_shouldNotCreateOrderProductNotFound() throws Exception {
        // given
        CustomerEntity createdCustomer = customerRepository.save(CustomerEntity.builder()
                .firstName(TEST_CUSTOMER_FIRST_NAME)
                .lastName(TEST_CUSTOMER_LAST_NAME)
                .latitude(TEST_DOUBLE_VALUE)
                .longitude(TEST_DOUBLE_VALUE)
                .build());
        CreateOrderRequest createOrder = CreateOrderRequest.builder()
                .customerId(createdCustomer.getId())
                .productId(0L)
                .build();

        // when
        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.post(ORDER_CONTROLLER_URL)
                                .accept(APPLICATION_JSON_VALUE)
                                .contentType(APPLICATION_JSON_VALUE)
                                .content(mapper.writeValueAsString(createOrder)))
                .andReturn();

        // then
        MockHttpServletResponse response = mvcResult.getResponse();
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
    }


}
