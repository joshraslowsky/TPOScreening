package testing.api.test;

import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import testing.api.Rest;
import testing.ui.test.BaseTest;

public class RestAPIPutTest extends BaseTest{
	
  @Test
  public void RestAPIConnectionTest() {
	  
  		String username = "jeff";
  		
  		//Create a Hashmap of Keys and Values for User based on Swagger Documents
  		HashMap<String, String> UserValues = new HashMap<String, String>();
  		UserValues.put("id", "1");   
  		UserValues.put("username", "testertester");   
  		UserValues.put("firstName", "Test");   
  		UserValues.put("lastName", "Testingtin");   
  		UserValues.put("email", "test@test.com");   
  		UserValues.put("password", "1234");   
  		UserValues.put("phone", "732-773-1111");   
  		UserValues.put("userStatus", "1");   

		try {
			 //Sends put request
			 Assert.assertEquals(Rest.sendPutRequest("https://petstore.swagger.io/v2/user/" + username , Rest.buildJsonObject(UserValues)),
					 200, "Succesfully Verified Post Request");
		} catch (Exception e) {
			e.printStackTrace();
		}
  }

}
