package com.micromart.product;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@Testcontainers
class ProductAPITest {

	@Container
	@ServiceConnection
	private static final MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

	@LocalServerPort
	private int port;


	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}


	@Test
	void Product_created_successfully_given_valid_request() {
		String requestBody = """
            {
                "name": "IPhone 15",
                "description": "Scam Mobile",
                "price": 1500
            }
            """;

		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.post("/api/products")
				.then()
				.statusCode(201);
	}

	@Test
	void Retrieve_all_products_successfully_given_valid_request() {
		RestAssured.given()
				.get("api/products")
				.then()
				.statusCode(200);
	}
}