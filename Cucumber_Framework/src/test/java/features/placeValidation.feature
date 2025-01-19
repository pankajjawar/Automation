Feature: Validating the PLACE APIs
@Addplace
Scenario Outline: Verify if place is successfully added using AddPlaceAPI
			Given Add place payload with "<name>" "<language>" "<language>"
			When user calls "AddPlaceAPI" with "POST" http request
			Then the API call is success with statuscode of 200
			And "status" in response body is "OK"
			And Verify place_id created maps to "<name>" in "getPlaceAPI"
			
Examples:
	|name|language|address|
	|Pankaj|English|India|

@Deleteplace		
Scenario: 
			Given Deleteplace payload
			When user calls "deletePlaceAPI" with "POST" http request
			Then the API call is success with statuscode of 200
			And "status" in response body is "OK"
			