package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import elements.Button;
import frmwrk.drivers.DriverManager;


public class HomePage extends BasePage {
	
	Button btnOffice365Menu = new Button(By.id("O365_MainLink_NavMenu"));
	
	
	public boolean isShown() {
		return btnOffice365Menu.isElementVisible();
	}

}
