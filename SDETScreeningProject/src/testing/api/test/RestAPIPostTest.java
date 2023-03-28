package testing.api.test;

import java.util.HashMap;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testing.api.Rest;
import testing.ui.test.BaseTest;

public class RestAPIPostTest extends BaseTest{
	
  @Test
  public void RestAPIConnectionTest() {
  
  		HashMap<String, String> orderValues = new HashMap<String, String>();
  		JSONObject json = new JSONObject();
  		orderValues.put("id", "0");   
  		orderValues.put("petId", "0");   
  		orderValues.put("quantity", "0");   
  		orderValues.put("shipDate", "2023-03-28T13:40:49.203Z");   
  		orderValues.put("status", "placed");   
  		orderValues.put("status", "true");   

		try {
			 Assert.assertEquals( Rest.sendPostRequest("https://petstore.swagger.io/v2/store/order/" , json),
					 200, "Succesfully Verified Post Request");
		} catch (Exception e) {
			e.printStackTrace();
		}
  }
  
}
