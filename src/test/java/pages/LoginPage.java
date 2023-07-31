package pages;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
	private By txtStaySignedIn = By.xpath("//div[contains(text(),'Stay signed in')]");

	public void loginWith(String username, String password) {
		Log.step("Logging into the application with " + username + "/" + password);
		setText(fldEmail, username);
		click(btnNext);
		setText(fldPassword, password);
		click(btnNext);
	}
	
	public void loginWithAdmin() {
		
		String email = null;
		String pass = null;
		
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("credentials.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find credentials.properties");
                return;
            }
            prop.load(input);
            email = prop.getProperty("app.usermail");
            pass = prop.getProperty("app.userpass");
		} catch (IOException ex) {
            ex.printStackTrace();
        }
		Log.step("Logging into the application with admin user");
		setText(fldEmail, email);
		click(btnNext);
		setText(fldPassword, pass);
		click(btnNext);
	}
	
	public void stayLoggedIn(Boolean wantToStayLoggedIn) {
		if (isElementVisible(txtStaySignedIn, 30000)) {
			if (wantToStayLoggedIn) {
				click(btnNext);
			} else {
				click(btnNo);
			}
		}
	}

	



}
