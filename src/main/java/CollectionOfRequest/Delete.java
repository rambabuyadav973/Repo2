package CollectionOfRequest;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Delete {
	public static String Newtitle=GetRandomString();
	
	@Test
	public void TC1() {
		//creation
		RestAssured.baseURI="http://localhost:3000";
		
		Response resp1=given().contentType(ContentType.JSON)
		.body("{\n"
				+ "    \n"
				+ "      \"id\": 7,\n"
				+ "      \"title\": \""+Newtitle+"\",\n"
				+ "      \"author\": \"Somu\"\n"
				+ "    }\n"
				+ "").when().post("/posts");
		
		//displAY
		assertEquals(resp1.getStatusCode(), 201);
		//display before deleting
		System.out.println("display before deleting");
		given().get("/posts").then().log().all();
		System.out.println("********************");
		
		
		String NewlyAdddedPOstId=resp1.jsonPath().getString("id");
		
		//DELETION
		
		Response ResOfDeletingReq=given().delete("/posts/"+NewlyAdddedPOstId+"");

		//Response ResOfDeletingID3=given().delete("/posts/3");
		//VERIFY if the above created data is deleted
		assertEquals(ResOfDeletingReq.statusCode(), 200);
		//assertEquals(ResOfDeletingID3.statusCode(), 200);
		System.out.println("The status code after deletion is as expected:"+ResOfDeletingReq.statusCode());
		//display after deleting
		System.out.println("display after deleting");
		
		given().get("/posts").then().log().all();
		System.out.println("***********************");
		
	}
	
//code to generate random string for all the request
	private static String GetRandomString() {
		
		Random random=new Random();
		String NewTitle="New"+random.nextInt();
		
				return NewTitle;
	}

}
