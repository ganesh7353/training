package com.restAssured.taining.get;

import org.testng.annotations.Test;

import com.restAssured.training.globals.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithDifferentFormat {
	@Test
	public void verifyBoardDemo()
	{
		System.out.println("API Call Started...");
		RestAssured.
			given().
				param("key", GlobalVariables.key).
				param("token",GlobalVariables.token).
			when().
				get("https://api.trello.com/1/boards/65ba0e97f69670eb88b91b4e").
			then().
				assertThat().statusCode(200);
		
		System.out.println("API Call Ended...");
		
	}
	@Test
	public void verifyBoardInGivenExpectFormat()
	{
		System.out.println("API Call Started...");
		RestAssured.
			given().
				param("key", GlobalVariables.key).
				param("token",GlobalVariables.token).
			expect().
				statusCode(200).
			when().
				get("https://api.trello.com/1/boards/65ba0e97f69670eb88b91b4e");
		System.out.println("API Call Ended...");
	}
	
	
	@Test
	public void verifyBoardUsingRestAssuredFormat()
	{
		System.out.println("Test Started");
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.param("key", GlobalVariables.key);
		reqSpec.param("token", GlobalVariables.token);
		reqSpec.header("accept", "application/json");
		
		Response response = reqSpec.get("https://api.trello.com/1/boards/65ba0e97f69670eb88b91b4e");
		
		response.prettyPrint();
		
		ValidatableResponse responseValidate = response.then();
		
		responseValidate.statusCode(200);
		System.out.println("Test Ended");
	}
}

