package com.restAssured.training.response.validatableResponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import static org.hamcrest.CoreMatchers.equalTo;

import com.restAssured.training.globals.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ValidatableResponse {
	ValidatableResponse response = null;
	
	@BeforeTest
	public void verifyBoardInBDDFormat() {
		System.out.println("API Call Started...");

		RestAssured.baseURI = "https://api.trello.com";
//		RestAssured.port = "8888";
		RestAssured.basePath = "1/boards/65b9e12baaa8172ece02a1c4";

		response = (ValidatableResponse) given().
				param("key", GlobalVariables.key).
				param("token", GlobalVariables.token).
				when().get().
				then()
				.assertThat().statusCode(200)
				.body("name", equalTo("{ganesh}"))
				.contentType(ContentType.JSON);
			
		System.out.println("API Call Ended...");
	}

	@Test
	public void printID()
	{
		String id = response.extract().path("id");		
		System.out.println("Printing ID : " + id);
//		JsonPath responseBody = new JsonPath(response.asString());
//		String id = response.extract().path("id");		
//		System.out.println("Printing ID : " + id);
	}
	
	@Test
	public void printAllUrls() {
		System.out.println("---------------printAllUrls Started ----------------");
		int totalUrls = response.extract().path("prefs.backgroundImageScaled.size()");
		System.out.println(totalUrls);
		for (int i = 0; i < totalUrls; i++) 
		{
			String url = response.extract().path("prefs.backgroundImageScaled["+i+"].url");
			System.out.println(url);
		}
		System.out.println("---------------printAllUrls Ended ----------------");
	}
	
	
	@Test
	public void printFirstBGImgeDetails()
	{
		System.out.println("---------------printFirstBGImgeDetails Started ----------------");
		Map<String, ?> item = response.extract().path("prefs.backgroundImageScaled[0]");
		Set<String> keys = item.keySet();
		for (String key : keys) 
		{
			System.out.println(key +" : "+item.get(key));
			
		}
		System.out.println("---------------printFirstBGImgeDetails Ended ----------------");
	}
	
	@Test
	public void printAllBGDetails()
	{
		System.out.println("---------------printAllBGDetails Started ----------------");
		List<Map<String,?>> allElements =  response.extract().path("prefs.backgroundImageScaled");
		
		for (int i = 0; i < allElements.size(); i++) 
		{
			System.out.println(i + " index item values");
			Map<String,?> item = allElements.get(i);
			
			Set<String> keys = item.keySet();
			for (String key : keys)
			{
				System.out.println(key + " : " + item.get(key));
			}
			
		}
		
		System.out.println("---------------printAllBGDetails Ended ----------------");
		
	}
	
	@Test
	public void printMapGreaterThanWidth1000()
	{
		System.out.println("---------------printMapGreaterThanWidth1000 Started ----------------");
		List<Map<String,?>> allElements = response.extract().path("prefs.backgroundImageScaled.findAll { it.width > 1000 }");
		
		for (int i = 0; i < allElements.size(); i++) 
		{
			System.out.println(i + " index item values");
			Map<String,?> item = allElements.get(i);
			
			Set<String> keys = item.keySet();
			for (String key : keys)
			{
				System.out.println(key + " : " + item.get(key));
			}
			
		}
		
		System.out.println("---------------printMapGreaterThanWidth1000 Ended ----------------");
		
	}
	
	
	@Test
	public void printAllURLGreaterThan1000s()
	{
		System.out.println("---------------printAllURLGreaterThan1000s Started ----------------");
		List<String> allElements =  response.extract().path("prefs.backgroundImageScaled.findAll { it.width > 1000 }.url");
		
		for (int i = 0; i < allElements.size(); i++) 
		{
				System.out.println(allElements.get(i));
		}
		
		System.out.println("---------------printAllURLGreaterThan1000s Ended ----------------");
		
	}
}
