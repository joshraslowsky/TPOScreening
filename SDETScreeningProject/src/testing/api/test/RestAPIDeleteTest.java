package testing.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import testing.api.Rest;
import testing.ui.test.BaseTest;

public class RestAPIDeleteTest extends BaseTest{
	
  @Test
  public void RestAPIConnectionTest() {
	try {
		 //Test given order number, if test is run multiple times on same number it will fail
		 int orderNumber = 10;
		 Assert.assertEquals(Rest.sendDeleteRequest("https://petstore.swagger.io/v2/store/order/" + orderNumber),
				 200, "Succesfully Verified Delete Request");
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
  		

  

}
