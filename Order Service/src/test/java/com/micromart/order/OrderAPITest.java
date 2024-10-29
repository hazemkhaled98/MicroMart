package com.micromart.order;


import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@Testcontainers
class OrderAPITest {

    @Container
    @ServiceConnection
    private static final MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.3.0");

    @LocalServerPort
    private int port;


    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }


    @Test
    void Order_created_successfully_given_valid_request() {
        String requestBody = """
                {
                  "skuCode": "SKU12345",
                  "price": 49.99,
                  "quantity": 10
                }
                """;

        RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/orders")
                .then()
                .statusCode(201);
    }
}
