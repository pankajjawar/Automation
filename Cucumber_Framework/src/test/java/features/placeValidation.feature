Feature: Validating the PLACE APIs

Scenario Outline: Verify if place is successfully added using AddPlaceAPI
			Given Add place payload with "<name>" "<language>" "<language>"
			When user calls "AddPlaceAPI" with "POST" http request
			Then the API call is success with statuscode of 200
			And statuscode "status" is response is "OK"
			
Examples:
	|name|language|address|
	|Pankaj|English|India|
	|Deepak|Hindi|Singapore|

			
