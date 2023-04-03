package testing.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import testing.api.Rest;
import testing.ui.test.BaseTest;

public class RestAPIGetTest extends BaseTest{
	
  @Test
  public void RestAPIConnectionTest() {
		try {
			 int orderNumber = 1;
			 Assert.assertEquals(Rest.sendGetRequest("https://petstore.swagger.io/v2/store/order/" + orderNumber),
					 200, "Succesfully Verified Get Request");
		} catch (Exception e) {
			e.printStackTrace();
		}	
  }

}
