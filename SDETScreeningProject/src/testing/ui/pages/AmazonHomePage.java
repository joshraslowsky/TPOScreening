package testing.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AmazonHomePage extends BasePage {

	//Global Variables
    WebElement txtSearchBar = driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']|//input[@title= 'Search For']"));
    WebElement firstSearchResult;
    
    /**
	 * Method enter given text into Amazon Search Bar
	 * @param text
	 * Josh Raslowsky 3/28/2023
	 */
    public void enterTextIntoSearchBar(String text)
    {
    	txtSearchBar.sendKeys(text);
    	txtSearchBar.submit();
    }
    
    /**
     * verifies text on first search result ignoring Case
     * @param textToVerify
     * @return boolean
     * Josh Raslowsky 3/28/2023
     */
    public boolean verifyFirstResultContainsText(String textToVerify)
    {
    	firstSearchResult = driver.findElement(By.xpath("(//span[@data-component-type = 's-search-results']//div[contains(@cel_widget_id  , 'MAIN-SEARCH_RESULTS')]//h2/a/span)[1]"));
    	String result = "";
    	
    	//Adding in Try to avoid crash if element does not have text
    	try {
    	 result = firstSearchResult.getText().toLowerCase();
    	}
    	catch(Exception e){
    		return false;
    	}
    	return result.contains(textToVerify.toLowerCase());
    }
    
    /**
     * verifies text on first search result Case Sensitive
     * @param textToVerify
     * @return boolean
     * Josh Raslowsky 3/28/2023
     */
    public boolean verifyFirstResultContainsTextCaseSensitive(String textToVerify)
    {
    	firstSearchResult = driver.findElement(By.xpath("(//span[@data-component-type = 's-search-results']//div[contains(@cel_widget_id  , 'MAIN-SEARCH_RESULTS')]//h2/a/span)[1]"));
    	String result = "";
    	
    	//Adding in Try to avoid crash if element does not have text
    	try {
    	 result = firstSearchResult.getText();
    	}
    	catch(Exception e){
    		return false;
    	}
    	return result.contains(textToVerify);
    }

}
