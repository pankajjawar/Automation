package APItests;

import Payload.Payloads;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js = new JsonPath(Payloads.GetPrice());
		
		//print the count of the courses
		int coursescount = js.getInt("courses.size()");
		System.out.println(coursescount);
		
		//print the title of the course
	     String coursetitle = js.getString("courses[0].title");
		System.out.println(coursetitle);
		
		//print the total purchase value
		int purchasevalue = js.getInt("dashboard.purchaseAmount");
		System.out.println(purchasevalue);
	}

}
