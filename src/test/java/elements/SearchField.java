package elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import frmwrk.locators.Locator;
import frmwrk.reporters.Log;

public class SearchField extends BaseElement {
	
	protected By by;
	private String searchControl = "//div[contains(@data-id,'_flyoutRootNode_SimpleLookupControlFlyout')]";
	
	public SearchField(Locator locator) {
		super(locator);
		this.by = locator.getLocator();
	}
	
	public SearchField(By by) {
		super(by);
		this.by = by;
	}
	
	public void searchFor(String searchText, int selectResulItem) {
		Log.debug("Searching for '" + searchText + "' on element " + by.toString() + " and selecting result number " + String.valueOf(selectResulItem));
		int tries = 0;
		By foundSearchResultBy = By.xpath(searchControl + "//ul//li");
		
		waitUntilElementIsPresent(by, defaultTimeOut);
		waitUntilElementIsVisible(by, defaultTimeOut);	
		
		WebElement element = getWebElement(by);
		element.click();
		do {
			element.clear();
			tries++;
		} while (!(element.getAttribute("value").equals("")) || (tries < 10));
		element.sendKeys(searchText);
		
		waitUntilElementIsPresent(foundSearchResultBy, defaultTimeOut);
		waitUntilElementIsVisible(foundSearchResultBy, defaultTimeOut);	
		getWebElements(foundSearchResultBy).get(selectResulItem).click();
	}


	public void searchFor(String searchText, String selectResultText) {
		Log.debug("Searching for '" + searchText + "' on element " + by.toString() + " and selecting the first result with text ' " + selectResultText + "'");
		int tries = 0;
		By foundSearchResultBy = By.xpath(searchControl + "//ul//li//span[contains(@class,'currentItemButton')]/span");
		
		waitUntilElementIsPresent(by, defaultTimeOut);
		waitUntilElementIsVisible(by, defaultTimeOut);	
		WebElement element = getWebElement(by);
		element.click();
		do {
			element.clear();
			tries++;
		} while (!(element.getAttribute("value").equals("")) || (tries < 10));
		element.sendKeys(searchText);
		
		
		
		
		
		
		waitForMilliseconds(200);
		element.clear();
		waitForMilliseconds(200);
		element.clear();
		waitForMilliseconds(200);
		//element.sendKeys(text);
		waitForMilliseconds(200);
		element.sendKeys(Keys.TAB);	
		//Log.debug("Text set of " + by.toString() + ": " + text);
	}
	
	private List<String> getAllListItems(){
		return null;
		
	}

	

}
