package validateTest;

import io.restassured.RestAssured;



	

	import static io.restassured.RestAssured.given;
	import static org.hamcrest.CoreMatchers.equalTo;

	import org.testng.annotations.Test;

	import com.restAssured.training.globals.GlobalVariables;

	import io.restassured.RestAssured;

	public class ConstantDemo {

		
		@Test
		public void verifyBoardInBDDFormat()
		{
			System.out.println("API Call Started...");
			
			RestAssured.baseURI = "https://api.trello.com";
//			RestAssured.port = "8888";
			RestAssured.basePath = "1/boards/65ba0e97f69670eb88b91b4e";

			given().
				param("key", GlobalVariables.key).
				param("token",GlobalVariables.token).
			when().
				get().
			then().
				assertThat().statusCode(200)
				.body("id", equalTo("65ba0e97f69670eb88b91b4e"))
				.body("name", equalTo("Eclipse-Created_Board1"));
			System.out.println("API Call Ended...");
		
	}
	
}
