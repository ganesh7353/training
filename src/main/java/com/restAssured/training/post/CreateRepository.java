package com.restAssured.training.post;



import java.util.Date;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import com.restAssured.training.globals.ConfigurationsClass;
import com.restAssured.training.globals.GlobalVariables;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.RestAssured;

public class CreateRepository {
private static final String String = null;
public static String project_Name=null;
	@Test
	public void CreateRepository() {
		RestAssured.baseURI=GlobalVariables.git_baseURI;
		String dateandtime = new Date().toString().replace(" ","_").replace(":","_");
		project_Name=""+dateandtime;
		String payLoadAsString = "{\r\n"
				+ "    \"name\": \"Hello-karanataka\",\r\n"
				+ "    \"description\": \"This is your first repo!\",\r\n"
				+ "    \"homepage\": \"https://github.com\",\r\n"
				+ "    \"private\": false,\r\n"
				+ "    \"is_template\": true\r\n"
				+ "}";
		given().headers("Authorization",GlobalVariables.git_basetoken)
		.headers("Content-Type","application/json").body(payLoadAsString)
		.post("/user/repos")
		.then().assertThat().statusCode(201).body("name",equalTo(project_Name) ).
		log().body();
		
				
	}
}
