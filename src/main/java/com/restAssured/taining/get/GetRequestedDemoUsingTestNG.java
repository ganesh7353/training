package com.restAssured.taining.get;

import org.testng.annotations.Test;

import com.restAssured.training.globals.GlobalVariables;

import io.restassured.RestAssured;

public class GetRequestedDemoUsingTestNG {

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
}
