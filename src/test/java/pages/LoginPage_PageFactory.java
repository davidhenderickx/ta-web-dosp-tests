package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import frmwrk.drivers.DriverManager;
import frmwrk.reporters.Log;

public class LoginPage_PageFactory extends BasePage {
		
	public LoginPage_PageFactory() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

	@FindBy(how = How.ID, using = "username")
	private WebElement fldUsername;

	@FindBy(id = "password")
	private WebElement fldPassword;
	
	@FindBy(how = How.XPATH, using = "//div[@id='login']//span[@class='content']")
	private WebElement btnLogin;

	@FindBy(how = How.NAME, using = "language")
	private WebElement cbxLanguage;

	@FindBy(how = How.ID, using = "errors")
	private WebElement lblError;

	public void loginWith(String username, String password) {
		Log.step("Logging into the application with " + username + "/" + password);
		fldUsername.clear();
		fldUsername.sendKeys(username);
		fldPassword.clear();
		fldPassword.sendKeys(password);
		WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		btnLogin.click();
		DriverManager.getDriver().switchTo().newWindow(WindowType.WINDOW);
	}

	public void setLanguageTo(String language) {
		Log.step("Setting the language to: " + language);
		Select selLanguage = new Select(cbxLanguage);
		selLanguage.selectByVisibleText(language);
	}
	
	public String getErrorMessage() {
		Log.step("returning the error message");
		return lblError.getText();
	}

}
