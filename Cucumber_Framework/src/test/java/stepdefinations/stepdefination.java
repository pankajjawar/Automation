package stepdefinations;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import Resources.TestData;
import Resources.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class stepdefination extends Utility {

	RequestSpecification request;
	Response response;
	TestData TD = new TestData();
	
	@Given("Add place payload")
	public void add_place_payload() throws FileNotFoundException {

		//RequestSpecBuilder		
		request = given().spec(Utility.RequestSpec()).body(TD.addPlaceData());
	}
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String string, String string2) {
		
		response = request.when().post("/maps/api/place/add/json").
		then().extract().response();
	  
	}
	@Then("the API call is success with statuscode of {int}")
	public void the_api_call_is_success_with_statuscode_is(Integer ExpectedResponse) {	
	assertEquals(response.getStatusCode(),200);
	}
	
	@Then("{string} is response is {string}")
	public void is_response_is(String key, String expectedValue) {
		String responseOutput = response.asString();
		JsonPath js = new JsonPath(responseOutput);
		System.out.println(js.get(key));
		assertEquals(js.get(key),expectedValue);
		
	}

}
