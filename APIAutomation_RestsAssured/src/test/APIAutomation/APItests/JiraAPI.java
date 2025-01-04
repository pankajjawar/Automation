package APItests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import java.io.File;
import org.testng.annotations.Test;

public class JiraAPI {
	
	@Test
	public static void BugTest() {
	RestAssured.baseURI="https://rahulshettyacademy-team.atlassian.net/";
	String Issuecreation = given().log().all().header("Content-Type","application/json")	
    .header("Authorization","Basic bWVudG9yQHJhaHVsc2hldHR5YWNhZGVteS5jb206QVRBVFQzeEZmR0YwdFNlOHYzNUtILWQtU3U4NUFMckIyTjdDNXIwY0pJU0djdFIwRFBybUhfZjVlUmg4dE5UUVV6UVp1dTFkMXJHdkRjUzNHRnV4TVE4WklSNU9tdFlPbUszLUxBbVU4OEFTM3JrOGkwODFSYV9kQTlPQ3J5QjRERXlFWldJYXpwWGw3VDFTWnBLY0ZOSDBucjVBMUtLQ3FuWVBldzFLR2JSMWowa2JFdGVNVFZFPUZCMzhFM0JB")
     .body("{\r\n"
     		+ "    \"fields\": {\r\n"
     		+ "       \"project\":\r\n"
     		+ "       {\r\n"
     		+ "          \"key\": \"SCRUM\"\r\n"
     		+ "       },\r\n"
     		+ "       \"summary\": \"My 2nd issue\",\r\n"
     		+ "       \"issuetype\": {\r\n"
     		+ "          \"name\": \"Bug\"\r\n"
     		+ "       }\r\n"
     		+ "   }\r\n"
     		+ "}").when().post("/rest/api/3/issue").then().assertThat().statusCode(201).extract().response().asString();
			

	JsonPath js = new JsonPath(Issuecreation);
	String issueID = js.get("id");
	
	  given().pathParam("key", issueID).header("X-Atlassian-Token","no-check")
		    .header("Authorization","Basic bWVudG9yQHJhaHVsc2hldHR5YWNhZGVteS5jb206QVRBVFQzeEZmR0YwdFNlOHYzNUtILWQtU3U4NUFMckIyTjdDNXIwY0pJU0djdFIwRFBybUhfZjVlUmg4dE5UUVV6UVp1dTFkMXJHdkRjUzNHRnV4TVE4WklSNU9tdFlPbUszLUxBbVU4OEFTM3JrOGkwODFSYV9kQTlPQ3J5QjRERXlFWldJYXpwWGw3VDFTWnBLY0ZOSDBucjVBMUtLQ3FuWVBldzFLR2JSMWowa2JFdGVNVFZFPUZCMzhFM0JB")
		   .multiPart("file", new File("C:\\Users\\LENOVO\\Pictures\\Capture.PNG")).when().post("/rest/api/3/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);

	}

	}
	
