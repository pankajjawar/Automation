package POJOClasses;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class SpecBuilder {
	
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
		
		//RequestSpecBuilder
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123").setContentType(ContentType.JSON).build();	
		RequestSpecification request = given().spec(req).body(S);
		
		//ResponseSpecBuilder
		ResponseSpecification resbuilder  = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		Response res = request.when().post("/maps/api/place/add/json").
		then().spec(resbuilder).extract().response();
		
		String Response = res.asString();
		
		System.out.println(Response);
	}

}
