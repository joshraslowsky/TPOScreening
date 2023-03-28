package testing.ui.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import testing.ui.pages.AmazonHomePage;
import testing.ui.pages.BasePage;


public class AmazonSearchTest extends BaseTest{
  @Test
  public void SearchTest() {
  		//Setup Driver and Navigate to amazon.com
		BasePage.driverSetup("https://amazon.com/");

		//Setup Home Page Class
		AmazonHomePage homePage = new AmazonHomePage();
		homePage.enterTextIntoSearchBar("Iphone");
		Assert.assertTrue(homePage.verifyFirstResultContainsText("Iphone"), "Succesfully Verified First Result Contained Iphone");
  }
  
  @AfterTest
  public void shutdownBrowser()
  {
	  //Close Down Driver once testing is completed
	  BasePage.closeDriver();
  }
}
