package restassurred;

import org.json.JSONObject;
import org.jsoup.Connection.Response;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import oracle.jdbc.NotificationRegistration.RegistrationState;

public class RestAssurred {

	private static String baseURI;

	public static void main(String[] args) {
		GetWeatherDetails();
		RegistrationSuccessful();
	}

	@Test
	public static void GetWeatherDetails() {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method
		// URL.
		// This will return the Response from the server. Store the response in a
		// variable.
		io.restassured.response.Response response = httpRequest.request(Method.GET, "/New York");

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

	}
	
	public static void RegistrationSuccessful()
	{ 
	 RestAssured.baseURI ="http://restapi.demoqa.com/customer";
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams = new JSONObject();
	 requestParams.put("FirstName", "Shamimi"); // Cast
	 requestParams.put("LastName", "Ahmedi");
	 requestParams.put("UserName", "shamim625i");
	 requestParams.put("Password", "passwordi");
	 
	 requestParams.put("Email",  "sample2ee26d9i@gmail.com");
	 request.body(((Object) requestParams).toString());
	 io.restassured.response.Response response = request.post("/register");
	 
	 int statusCode = ((ResponseOptions<io.restassured.response.Response>) response).getStatusCode();
	 Assert.assertEquals(statusCode, 200);
	 String successCode = ((ResponseBodyExtractionOptions) response).jsonPath().get("SuccessCode");
	 Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}

}
