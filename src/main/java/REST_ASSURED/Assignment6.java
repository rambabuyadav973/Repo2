package REST_ASSURED;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
public class Assignment6 {
	@Test

	public void test_deleteUser() { 
		RestAssured.useRelaxedHTTPSValidation();

	baseURI="https://reqres.in";

	given().
	delete("/api/users/2").

	then().

	statusCode (204).

	log().all();

	}


}
