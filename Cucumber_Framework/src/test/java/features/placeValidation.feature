Feature: Validating the PLACE APIs

Scenario: Verify if place is successfully added using AddPlaceAPI
			Given Add place payload
			When user calls "AddPlaceAPI" with "POST" http request
			Then the API call is success with statuscode of 200
			And "status" is response is "OK"
