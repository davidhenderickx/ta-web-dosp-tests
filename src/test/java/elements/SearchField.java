package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import frmwrk.locators.Locator;
import frmwrk.reporters.Log;

public class SearchField extends BaseElement {
	
	protected By by;
	
	public SearchField(Locator locator) {
		this.by = locator.getLocator();
		elementLocator = locator.getLocator();
	}
	
	public SearchField(By by) {
		this.by = by;
		elementLocator = by;
	}


	public void setText(String searchText, String selectText, int searchResult) {
		//Log.debug("Setting the text '" + text + "' on element " + by.toString());
		waitUntilElementIsPresent(by, defaultTimeOut);
		waitUntilElementIsVisible(by, defaultTimeOut);
		WebElement element = getWebElement(by);
		element.click();
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

	

}
