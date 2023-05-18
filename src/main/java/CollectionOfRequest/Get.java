package CollectionOfRequest;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get {
	@Test
	public void TC1() {
		//base url
		RestAssured.baseURI="http://localhost:3000/";
		// to get details in console
		given().get("/posts/2").then().log().all();
		//send request and get response
		// Comment12ParasResponse Response= given().get("/posts/2").then().extract().response();
		//response is in json format
		//change response to string
		assertEquals(Response.getStatusCode(), 200);
		assertEquals(Response.jsonPath().getString("id"), "2");
		assertEquals(Response.jsonPath().getString("title"), "title0000");
		
		assertEquals(Response.jsonPath().getString("jdshgfudj"), "title0000");
	}

}
