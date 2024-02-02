package com.restAssured.training.response.logs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import com.restAssured.training.globals.GlobalVariables;
import com.restAssured.training.response.validatableResponse.ValidatableResponse;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class LoggingDemo {
	
	ValidatableResponse response = null;
	@Test
	public void logRequestOnly() {
		System.out.println("API Call Started...");

		RestAssured.baseURI = "https://api.trello.com";
//		RestAssured.port = "8888";
		RestAssured.basePath = "1/boards/65b9e12baaa8172ece02a1c4";

		response = (ValidatableResponse) given().
				param("key", GlobalVariables.key).
				param("token", GlobalVariables.token).
				when().get().
				then().log().all().
				assertThat().statusCode(200)
				.body("name", equalTo("{ganesh}"))
				.contentType(ContentType.JSON);
			
		System.out.println("API Call Ended...");
	}
	@Test
	public void logRequestAndResponseOnly() {
		System.out.println("API Call Started...");

		RestAssured.baseURI = "https://api.trello.com";
//		RestAssured.port = "8888";
		RestAssured.basePath = "1/boards/65b9e12baaa8172ece02a1c4";

		response = (ValidatableResponse) given().
				param("key", GlobalVariables.key).
				param("token", GlobalVariables.token).
				when().get().
				then().log().headers().
				assertThat().statusCode(200)
				.body("name", equalTo("{ganesh}"))
				.contentType(ContentType.JSON);
			
		System.out.println("API Call Ended...");
	}
}
