package stepdefinations;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.*;
import java.io.IOException;
import Resources.ApiResources;
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
	JsonPath js;
	TestData TD = new TestData();
	static String getplaceid;
	
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		//RequestSpecBuilder
		request = given().spec(Utility.requestSpec()).body(TD.addPlaceData(name,language,address));
	}
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String httpmethod) {
		//enum class is used , constructor will be called with valueof method for the passing the resource
		ApiResources Apiresource = ApiResources.valueOf(resource);
		Apiresource.getResource();
		if(httpmethod.equalsIgnoreCase("POST"))
		response = request.when().post(Apiresource.getResource());
		else if(httpmethod.equalsIgnoreCase("GET"))
		response = request.when().get(Apiresource.getResource());	
	}
	
	@Then("the API call is success with statuscode of {int}")
	public void the_api_call_is_success_with_statuscode_is(Integer ExpectedResponse) {	
	assertEquals(response.getStatusCode(),200);
	}

	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedValue) {
		assertEquals(getJsonValue(response,key),expectedValue);
	}
	
	@Then("Verify place_id created maps to {string} in {string}")
	public void verify_place_id_created_maps_to_in(String actualname, String resource) throws IOException {
	   getplaceid = getJsonValue(response,"place_id");
	   System.out.println(getplaceid);
	   request = given().spec(Utility.requestSpec()).queryParam("place_id", getplaceid);
		user_calls_with_http_request(resource,"GET");
		assertEquals(getJsonValue(response,"name"),actualname);
	}
	
	@Given("Deleteplace payload")
	public void deleteplace_payload() throws IOException {
		request= given().spec(Utility.requestSpec()).when().body(TD.deletePlaceData(getplaceid));

	}




}
