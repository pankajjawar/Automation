package APItests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class PassingAPIFiles {

			
 @Test 
		public void APIFiles() throws IOException {
			RestAssured.baseURI = "https://rahulshettyacademy.com";
			String Response = given().log().all().header("Content-Type","text/plain").body(new String(Files.readAllBytes(Paths.get("C:\\Users\\LENOVO\\eclipse-workspace\\APIAutomation_RestsAssured\\addBook1.json")))).
			when().post("/Library/Addbook.php").
			then().assertThat().statusCode(200).extract().response().asString();
			System.out.println(Response);
		}


}
