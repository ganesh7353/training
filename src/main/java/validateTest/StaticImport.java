package validateTest;




import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import com.restAssured.training.globals.GlobalVariables;

import io.restassured.RestAssured;


import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;

public class StaticImport {
	
	@Test
	public void verifyBoardInBDDFormat()
	{
		System.out.println("API Call Started...");
		
			given().
				param("key", GlobalVariables.key).
				param("token",GlobalVariables.token).
			when().
				get("https://api.trello.com/1/boards/65ba0e97f69670eb88b91b4e").
			then().
				assertThat().statusCode(200)
				.body("id", equalTo("65ba0e97f69670eb88b91b4e"))
				.body("name", equalTo("Eclipse-Created_Board1"));
		System.out.println("API Call Ended...");
	
	
}
}
