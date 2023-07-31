package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import frmwrk.locators.Locator;
import frmwrk.reporters.Log;

public class Field extends BaseElement {
	
	protected By by;
	
	public Field(Locator locator) {
		this.by = locator.getLocator();
	}
	
	public Field(By by) {
		this.by = by;
	}

	public void setText(String text) {
		Log.debug("Setting the text '" + text + "' on element " + by.toString());
		waitUntilElementIsPresent(by, defaultTimeOut);
		waitUntilElementIsVisible(by, defaultTimeOut);
		WebElement element = getWebElement(by);
		element.clear();
		element.sendKeys(text);
		element.sendKeys(Keys.TAB);	
	}

	

}
