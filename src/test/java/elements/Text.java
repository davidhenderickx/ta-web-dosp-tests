package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import frmwrk.locators.Locator;
import frmwrk.reporters.Log;

public class Text extends BaseElement {
	
	protected By by;
	
	public Text(Locator locator) {
		this.by = locator.getLocator();
	}
	
	public Text(By by) {
		this.by = by;
	}

	public String getText() {
		Log.debug("Getting the text from element " + by.toString());
		waitUntilElementIsPresent(by, defaultTimeOut);
		waitUntilElementIsVisible(by, defaultTimeOut);
		WebElement element = getWebElement(by);
		return element.getText();
	}

	

}
