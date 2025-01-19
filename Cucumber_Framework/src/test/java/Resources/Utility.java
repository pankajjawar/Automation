package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utility {
	public static RequestSpecification req;
	
	public static RequestSpecification requestSpec() throws IOException {

		if(req==null) {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt")); 
		req = new RequestSpecBuilder().setBaseUri(globalVariable("BaseURL")).addQueryParam("key","qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).
				setContentType(ContentType.JSON).build();
		return req;
		}
		return req;
	}
	
	public static String globalVariable(String Key) throws IOException {
		Properties GV = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\Cucumber_Framework\\src\\test\\java\\Resources\\Globalvariables.properties");
		GV.load(fis);
		return GV.getProperty(Key);
	}
	
	public String getJsonValue(Response response,String key) {
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		return js.get(key).toString();
	}

}
