package com.restAssured.training.response.jayway;

import org.testng.annotations.BeforeMethod;

import com.restAssured.training.globals.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


	import static io.restassured.RestAssured.given;

	import java.util.List;
	import java.util.Map;
	import java.util.Set;

	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import com.jayway.jsonpath.JsonPath;
	import com.restAssured.training.globals.GlobalVariables;

	import io.restassured.RestAssured;
	import io.restassured.response.Response;
	
	public class JayawayDemo {


		
		Response response = null;
		
		@BeforeTest
		public void verifyBoardInBDDFormat() {
			System.out.println("API Call Started...");

			RestAssured.baseURI = "https://api.trello.com";
//			RestAssured.port = "8888";
			RestAssured.basePath = "1/boards/65b9e12baaa8172ece02a1c4";

			response = given().
				param("key", GlobalVariables.key).
				param("token", GlobalVariables.token).
			when().get();
			System.out.println("API Call Ended...");
		}
		
		
		@Test
		public void printID()
		{
			 String id = JsonPath.read(response.asString(), "$.id");
			 System.out.println("Printing ID : " + id);
		}
		
		public void printAllUrls() {
			System.out.println("---------------printAllUrls Started ----------------");
			List<String> urls = JsonPath.read(response.asString(), "$.prefs.backgroundImageScaled[*].url");
			for (String url : urls) 
			{
				System.out.println("URL :: "  + url);
				
			}
			System.out.println("---------------printAllUrls Ended ----------------");
		}
		@Test
		public void printFirstBGImgeDetails()
		{
			System.out.println("---------------printFirstBGImgeDetails Started ----------------");
			Map<String, ?> item = JsonPath.read(response.asString(), "$.prefs.backgroundImageScaled[0]");
			
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
			List<Map<String,?>> allElements =  JsonPath.read(response.asString(), "prefs.backgroundImageScaled");
			
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
		public void printMapGreaterThanWidth1000s()
		{
			System.out.println("---------------printAllBGDetails Started ----------------");
			List<Map<String,?>> allElements =  JsonPath.read(response.asString(), "prefs.backgroundImageScaled.[?(@.width>1000)]");
			
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
	}
