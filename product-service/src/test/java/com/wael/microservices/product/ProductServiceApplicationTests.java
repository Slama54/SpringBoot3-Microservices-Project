package com.wael.microservices.product;


import io.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

//@Import(TestcontainersConfiguration.class)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");
	@LocalServerPort
	private  Integer port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
    }
	static {
		mongoDBContainer.start();
	}
	@Test
	void shouldCreateProduct() {
		String requestBody = """
				{
				    "name":"iphone 14",
				    "description":"iphone 15 is a smart phone from Apple",
				    "price" :900
				}
				            """;
        RestAssured
				.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("api/product")
				.then()
				.statusCode(201)
				.body("id", Matchers.notNullValue())
				.body("name", Matchers.equalTo("iphone 14"))
				.body("description", Matchers.equalTo("iphone 15 is a smart phone from Apple"))
				.body("price", Matchers.equalTo(900));

	}

}
