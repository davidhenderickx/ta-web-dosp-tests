package pages;

import org.openqa.selenium.By;

import elements.Button;
import elements.Combobox;
import elements.Field;
import elements.Text;
import frmwrk.reporters.Log;

public class LoginPage_Elements extends BasePage {

	public Field fldUsername = new Field(By.id("username"));
	public Field fldPassword = new Field(By.id("password"));
	public Button btnLogin = new Button(By.xpath("//div[@id='login']//span[@class='content']"));
	private Combobox cbxLanguage = new Combobox(By.name("language"));
	private Text txtError = new Text(By.id("errors"));

	public void loginWith(String username, String password) {
		Log.step("Logging into the application with " + username + "/" + password);
		fldUsername.setText(username);
		fldPassword.setText(password);
		btnLogin.click();
	}

	public void setLanguageTo(String language) {
		Log.step("Setting the language to: " + language);
		cbxLanguage.selectByVisibleText(language);
	}

	public String getErrorMessage() {
		Log.step("returning the error message");
		return txtError.getText();
	}

}
