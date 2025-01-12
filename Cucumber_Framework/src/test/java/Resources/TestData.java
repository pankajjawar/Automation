package Resources;

import java.util.ArrayList;
import java.util.List;

import Pojoclases.Location;
import Pojoclases.SerializationAddPlace;

public class TestData {
	
	public Object addPlaceData() {
		
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
		return S;
	}

}
