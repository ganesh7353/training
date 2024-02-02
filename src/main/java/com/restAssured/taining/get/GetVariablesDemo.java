package com.restAssured.taining.get;
import com.restAssured.training.globals.GlobalVariables;

import io.restassured.RestAssured;
public class GetVariablesDemo {
	

public static void main(String[] args)
		{
			System.out.println("API Call Started...");
			RestAssured.
				given().
					param("key", GlobalVariables.key).
					param("token",GlobalVariables.token).
				when().
					get("https://api.trello.com/1/boards/65b9e12baaa8172ece02a1c4").
				then().
					assertThat().statusCode(200);
			
			System.out.println("API Call Ended...");
			
		}
	}

