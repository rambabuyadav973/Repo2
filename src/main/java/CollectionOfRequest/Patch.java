package CollectionOfRequest;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Patch {
public static String Newtitle=GetRandomString();
	
	@Test
	public void TC1() {
		//creation
		RestAssured.baseURI="http://localhost:3000";
		//to get details in console
		Response resp1=given().contentType(ContentType.JSON)
		.body("{\n"
				+ "        \n"
				+ "        \"title\": \""+Newtitle+"\"\n"
				+ "       \n"
				+ "    }").when().patch("/posts/2");
		
		//response code of post request
		assertEquals(resp1.statusCode(), 200);
		assertEquals(resp1.jsonPath().getString("title"), Newtitle);
		given().get("/posts").then().log().all();
		

}

	private static String GetRandomString() {

		Random random=new Random();
		String NewTitle="New"+random.nextInt();
		
				return NewTitle;
	}
}
