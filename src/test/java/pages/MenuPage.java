package pages;

import org.openqa.selenium.By;
import elements.Button;
import frmwrk.reporters.Log;

public class MenuPage extends BasePage {
	
	private Button btnContactPersons = new Button(By.id("sitemap-entity-SubArea_Contacts"));
	
	public void ContactPersons() {
		Log.step("Clicking on the contact persons item");
		btnContactPersons.click();
	}

	


}
