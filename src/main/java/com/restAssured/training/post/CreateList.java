package com.restAssured.training.post;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.restAssured.training.globals.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CreateList {
	@BeforeMethod
	public void initialize() {
		RestAssured.baseURI="https://api.trello.com";
		
	}
	@AfterMethod
	public void afterCreate() {
		RestAssured.reset();
	}
	@Test
	public void createBoard() {
		
		
		Response response= RestAssured.given().
				queryParam("key",GlobalVariables.key).
				queryParam("token",GlobalVariables.token).
				queryParam("name","Eclipse-Created_List").
				queryParam("idBoard","65ba0e97f69670eb88b91b4e").
				header("Content-type","application/json").
				
				
				
				when().
				post("/1/lists/");
		        response.prettyPrint();
		        
		ValidatableResponse vResponse =response.then();
		
		vResponse.statusCode(200);
	}


	
}
