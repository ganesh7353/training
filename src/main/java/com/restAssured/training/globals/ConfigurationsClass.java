package com.restAssured.training.globals;
import io.restassured.RestAssured;

public class ConfigurationsClass {

	
		

		
			
			static
			{
				RestAssured.baseURI = "https://api.trello.com";
//				RestAssured.port = "8888";
				RestAssured.basePath = "1/boards/65ba0e97f69670eb88b91b4e";
			}
			
		}
	


