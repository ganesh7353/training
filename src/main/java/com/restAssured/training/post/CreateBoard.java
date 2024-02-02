package com.restAssured.training.post;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.restAssured.training.globals.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CreateBoard {
@BeforeMethod
public void initialize() {
	RestAssured.baseURI="https://api.trello.com";
	
}
@Test
public void createBoard() {
	
	
	Response response= RestAssured.given().
			queryParam("key",GlobalVariables.key).
			queryParam("token",GlobalVariables.token).
			queryParam("name","Eclipse-Created_Board1").
			header("Content-type","application/json").
			
			
			
			when().
			post("/1/boards/");
	        response.prettyPrint();
	        
	ValidatableResponse vResponse =response.then();
	
	vResponse.statusCode(200);
}


@AfterMethod
public void afterCreate() {
	RestAssured.reset();
}
}
