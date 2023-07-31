package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frmwrk.drivers.DriverManager;

public class AdminPage extends BasePage {

	public AdminPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
	
	@FindBy(how = How.ID, using = "new_username")
	private WebElement fldUsername;

	@FindBy(how = How.ID, using = "new_password")
	private WebElement fldPassword;

	@FindBy(how = How.XPATH, using = "//td[@onclick='createUser()']/span")
	private WebElement btnCreateNewUser;

	@FindBy(how = How.XPATH, using = "//td[@onclick='resetUsers(true)']/label")
	private WebElement btnResetUser;

	public void clickResetUsers() {
		System.out.println("Clicking on reset users");
		btnResetUser.click();
	}

	public String getAlertText() {
		Alert popup = DriverManager.getDriver().switchTo().alert();
		return popup.getText();
	}

	public void closeAlert() {
		System.out.println("Closing the alert");
		Alert popup = DriverManager.getDriver().switchTo().alert();
		popup.dismiss();
	}

	public void createUser(String username, String password) {
		System.out.println("Creating a new user");
		fldUsername.clear();
		fldUsername.sendKeys(username);
		fldPassword.clear();
		fldPassword.sendKeys(password);
		btnCreateNewUser.click();
	}

}
