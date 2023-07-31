package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frmwrk.drivers.DriverManager;


public class WelcomePage extends BasePage {
	
	public WelcomePage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

	@FindBy(how = How.ID, using = "welcome")
	private WebElement txtWelcome;

	public String getWelcomeMessage() {
		return txtWelcome.getText();
	}

	public Boolean isWelcomeMessageDisplayed() {
		return txtWelcome.isDisplayed();
	}

}
