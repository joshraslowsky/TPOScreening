package testing.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	public static WebDriver driver;
	
	/**
	 * Method to Instantiate Chrome Browser with Given URL
	 * @param url
	 * Josh Raslowsky 3/27/2023
	 */
      public static void driverSetup(String url) {
	     //Driver Location Setup for Chrome Driver
	     System.setProperty("webdriver.chome.driver", "C:/Users/joshr/eclipse-workspace/SDETScreeningProject/drivers/chromedriver.exe");
	     
	     //Invoke Browser
	     driver = new ChromeDriver();
	     
	     //Navigate to given url and maximize
	     driver.get(url);
	     driver.manage().window().maximize();
    }
      
      
      /**
  	 * Method to close chrome browser once test is completed
  	 * @param url
  	 * Josh Raslowsky 3/27/2023
  	 */
      public static void closeDriver() {	
        driver.close();
      }
}
