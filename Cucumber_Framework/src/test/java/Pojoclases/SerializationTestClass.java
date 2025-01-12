package Pojoclases;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class SerializationTestClass {
	
	@Test
	public void Serialization() {
		
		SerializationAddPlace S = new SerializationAddPlace();
		S.setAccuracy("50");
		S.setAddress("Hyderabad");
		S.setLanguage("English");
		S.setName("Pankaj Jhawar");
		S.setWebsite("World.com");
		List<String> L = new ArrayList<String>();
		L.add("Hello");
		L.add("Bye");
		S.setTypes(L);
		Location loc = new Location();
		loc.setLat(3.1233);
		loc.setLng(23.1121);
		S.setLocation(loc);
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String res = given().log().all().queryParam("key","qaclick123").body(S).when().post("/maps/api/place/add/json").
		then().log().all().statusCode(200).extract().response().asString();
		
		System.out.println(res);
	}

}
