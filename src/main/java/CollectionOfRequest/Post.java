package CollectionOfRequest;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post {
	@Test
	public void TC1() {
	//base url
			RestAssured.baseURI="http://localhost:3000/";
			// to get details in console
			Response resp1=given()
					.contentType(ContentType.JSON)
			.body("{\n"
					+ "    \n"
					+ "      \"id\": 4,\n"
					+ "      \"title\": \"title4\",\n"
					+ "      \"author\": \"kannan\"\n"
					+ "    }\n"
					+ "").when().post("/posts");
			
			//response code of post request
			assertEquals(resp1.getStatusCode(), 201);
			
			//send request and get response
			Response Response2= given().get("/posts/4").then().extract().response();
			//response is in json format
			//change response to string
			assertEquals(Response2.getStatusCode(), 200);
			assertEquals(Response2.jsonPath().getString("id"), "4");
			assertEquals(Response2.jsonPath().getString("title"), "title4");
	}	

}
