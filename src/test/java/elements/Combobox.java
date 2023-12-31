package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import frmwrk.locators.Locator;
import frmwrk.reporters.Log;

public class Combobox extends BaseElement {
	
	protected By by;
	protected Select select;
	
	public Combobox(Locator locator) {
		super(locator);
		this.by = locator.getLocator();
	}
	
	public Combobox(By by) {
		super(by);
		this.by = by;
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
