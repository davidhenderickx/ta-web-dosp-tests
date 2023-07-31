package elements;

import org.openqa.selenium.By;

import frmwrk.locators.Locator;
import frmwrk.reporters.Log;

public class Button extends BaseElement {
	
	protected By by;
	
	
	public Button(Locator locator) {
		this.by = locator.getLocator();
		elementLocator = locator.getLocator();
	}
	
	public Button(By by) {
		this.by = by;
		elementLocator = by;
	}

	public void click() {
		Log.debug("Clicking on the element " + by.toString());
		waitUntilElementIsPresent(by, defaultTimeOut);
		waitUntilElementIsVisible(by, defaultTimeOut);
		waitUntilElementIsClickable(by, defaultTimeOut);
		getWebElement(by).click();;	
	}

}
