package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import frmwrk.locators.Locator;
import frmwrk.reporters.Log;

public class Field extends BaseElement {
	
	protected By by;
	
	public Field(Locator locator) {
		super(locator);
		this.by = locator.getLocator();
	}
	
	public Field(By by) {
		super(by);
		this.by = by;
	}

	@Override
	public void setText(String text) {
		Log.debug("Setting the text '" + text + "' on element " + by.toString());
		waitUntilElementIsPresent(by, defaultTimeOut);
		waitUntilElementIsVisible(by, defaultTimeOut);
		WebElement element = getWebElement(by);
		element.click();
		waitForMilliseconds(200);
		element.clear();
		waitForMilliseconds(200);
		element.clear();
		waitForMilliseconds(200);
		element.sendKeys(text);
		waitForMilliseconds(200);
		element.sendKeys(Keys.TAB);	
		Log.debug("Text set of " + by.toString() + ": " + text);
	}

	

}
