package pages;

import org.openqa.selenium.By;
import elements.Button;
import frmwrk.reporters.Log;

public class MenuPage extends BasePage {
	
	private Button btnLogout = new Button(By.id("logout"));
	private Button btnAdmin = new Button(By.linkText("Admin"));
	private Button btnNotFound = new Button(By.xpath("//div[@id='login']//span[@class='content']//WILLNOTBEFOUND"));

	public void logout() {
		Log.step("Clicking logout");
		btnLogout.click();
	}

	public void admin() {
		Log.step("Clicking admin");
		btnAdmin.click();
	}

	public void buttonDoesntExist() {
		Log.step("Clicking a button that doesn't exist");
		btnNotFound.click();
	}


}
