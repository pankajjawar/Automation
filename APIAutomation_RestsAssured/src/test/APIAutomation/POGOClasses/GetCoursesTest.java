package POGOClasses;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetCoursesTest {
	
	@Test
	public void GetCoursesDetailsTests() {
		

		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String access_response = given().log().all().multiPart("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.multiPart("client_secret", "erZOWM9g3UtwNRj340YYaK_W").multiPart("grant_type", "client_credentials").multiPart("scope","trust")
		.when().post("/oauthapi/oauth2/resourceOwner/token").then().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(access_response);
		String access_token1 = js.get("access_token");
		System.out.println(access_token1);
		
		GetCoursesDetails gc=given().log().all().queryParam("access_token", access_token1)
		.when().get("/oauthapi/getCourseDetails").then().log().all().statusCode(401).extract().response().as(GetCoursesDetails.class);
		
		System.out.println(gc.getInstructor());
		System.out.println(gc.getLinkedIn());
		
		System.out.println("===get the price of the course SoapUI Webservices testing==");
		
		List<API> Api = gc.getCourses().getApi();
		for (int i=0;i<Api.size();i++) {
			if(gc.getCourses().getApi().get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
				System.out.println(gc.getCourses().getApi().get(i).getPrice());
				break;
			}	
		}
		
		String[] Titles = {"Selenium Webdriver Java","Cypress","Protractor"};
		ArrayList<String> a = new ArrayList<String>();
		System.out.println("===Print All the course titles in webautomation along with validation==");
		List<WebAutomation> webtitles = gc.getCourses().getWebAutomation();
		for (int j=0;j<webtitles.size();j++) {
				a.add(webtitles.get(j).getCourseTitle());
		}
				List<String> ExpectedTitles = Arrays.asList(Titles);
				Assert.assertEquals(ExpectedTitles, a);
			}	
	}
