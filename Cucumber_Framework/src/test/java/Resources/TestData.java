package Resources;

import java.util.ArrayList;
import java.util.List;
import Pojoclases.Location;
import Pojoclases.SerializationAddPlace;

public class TestData {
	
	public Object addPlaceData(String name, String language, String address ) {
		
		SerializationAddPlace S = new SerializationAddPlace();
		S.setAccuracy("50");
		S.setAddress(address);
		S.setLanguage(language);
		S.setName(name);
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
