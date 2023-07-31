package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import frmwrk.locators.Locator;
import frmwrk.reporters.Log;

public class Combobox extends BaseElement {
	
	protected By by;
	protected Select select;
	
	public Combobox(Locator locator) {
		this.by = locator.getLocator();
		elementLocator = locator.getLocator();
	}
	
	public Combobox(By by) {
		this.by = by;
		elementLocator = by;
	}

	public void selectByVisibleText(String text) {
		Log.debug("Selecting '" + text + "' on combobox " + by.toString());
		waitUntilElementIsPresent(by, defaultTimeOut);
		waitUntilElementIsVisible(by, defaultTimeOut);
		select = new Select(getWebElement(by));
		select.selectByVisibleText(text);	
		Log.debug("Selected '" + text + "' on combobox " + by.toString());
	}

}
