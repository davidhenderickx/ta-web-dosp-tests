package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import frmwrk.drivers.DriverManager;
import frmwrk.locators.Locator;
import frmwrk.locators.WebLocator;
import frmwrk.reporters.Log;

public class LoginPage extends BasePage {
	
	private By btnNext = By.id("idSIButton9");
	private By btnNo = By.id("idBtn_Back");
	private By fldEmail = By.xpath("//input[@name='loginfmt' and @type='email']");
	private By fldPassword = By.xpath("//input[@name='passwd' and @type='password']");

	public void loginWith(String username, String password) {
		Log.step("Logging into the application with " + username + "/" + password);
		setText(fldEmail, username);
		click(btnNext);
		setText(fldPassword, password);
		click(btnNext);
	}
	
	public void loginWithAdmin() {
		Log.step("Logging into the application with admin user");
		setText(fldEmail, "david.henderickx@dosp.cloud");
		click(btnNext);
		setText(fldPassword, "Testing001!");
		click(btnNext);
	}
	
	public void stayLoggedIn(Boolean wantToStayLoggedIn) {
		if (wantToStayLoggedIn) {
			click(btnNext);
		} else {
			click(btnNo);
		}
	}

	



}
