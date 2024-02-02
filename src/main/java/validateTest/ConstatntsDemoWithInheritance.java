package validateTest;




import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import com.restAssured.training.globals.ConfigurationsClass;
import com.restAssured.training.globals.GlobalVariables;

import io.restassured.RestAssured;

public class ConstatntsDemoWithInheritance extends ConfigurationsClass {
	@Test
	public void verifyBoardInBDDFormat()
	{
		System.out.println("API Call Started...");
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

