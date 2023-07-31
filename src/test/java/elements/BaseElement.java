package elements;

import org.openqa.selenium.By;

import frmwrk.locators.Locator;

public class BaseElement extends frmwrk.testbase.BaseElement {
	
	By by;
	
	public BaseElement(Locator locator) {
		super(locator);
		this.by = locator.getLocator();
		
	}
	
	public BaseElement(By by) {
		super(by);
		this.by = by;	
	}
	
	
	

}
