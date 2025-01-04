package APItests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Payload.Payloads;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//given - all input details 
		//when - Submit the API -resource,http method
		//Then - validate the response
	   RestAssured.baseURI= "https://rahulshettyacademy.com";
	   //PostAPI
	   String Response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(Payloads.AddPlace()).when().post("/maps/api/place/add/json")
	   .then().statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
	   
	   //To extract the value from the response
	   JsonPath js = new JsonPath(Response);
	   String Place_ID = js.getString("place_id");
	   System.out.println(Place_ID);
	   
	   String ExpectedAddress = "70 winter walk, USA";
	   
	   //updateAPI
	   given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n"
	   		+ "\"place_id\":\""+Place_ID+"\",\r\n"
	   		+ "\"address\":\"70 winter walk, USA\",\r\n"
	   		+ "\"key\":\"qaclick123\"\r\n"
	   		+ "}").when().put("/maps/api/place/update/json").then().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
			   
	   String GetResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id",Place_ID).when().get("/maps/api/place/get/json")
	   .then().log().all().statusCode(200).extract().response().asString();
	   
	   JsonPath js1 = new JsonPath(GetResponse);
	   String Address = js1.getString("address");
	   System.out.println(Address);
	   Assert.assertEquals(Address, ExpectedAddress);
	   	}

}
