package APItests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class Oauth2 {
	
	@Test
	public void GetAccessToken() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String access_response = given().log().all().multiPart("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.multiPart("client_secret", "erZOWM9g3UtwNRj340YYaK_W").multiPart("grant_type", "client_credentials").multiPart("scope","trust")
		.when().post("/oauthapi/oauth2/resourceOwner/token").then().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(access_response);
		String access_token1 = js.get("access_token");
		System.out.println(access_token1);
		
		given().log().all().queryParam("access_token", access_token1)
		.when().get("/oauthapi/getCourseDetails").then().log().all().statusCode(401).extract().response().asString();
		
	}

}
