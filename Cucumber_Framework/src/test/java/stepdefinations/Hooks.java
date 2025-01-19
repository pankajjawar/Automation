package stepdefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@Deleteplace")
	public void beforeScenario() throws IOException  {
		stepdefination m = new stepdefination();
		if(stepdefination.getplaceid==null) {
		m.add_place_payload_with("Deepka", "Hindi", "Singapore");
		m.user_calls_with_http_request("AddPlaceAPI", "POST");
		m.verify_place_id_created_maps_to_in("Deepka", "getPlaceAPI");
		}
	}

}
