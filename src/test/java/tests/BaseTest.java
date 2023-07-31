package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import frmwrk.drivers.DriverManager;
import frmwrk.enums.Environment;
import frmwrk.settings.RunSettings;
import pages.AdminPage;
import pages.LoginPage_Elements;
import pages.LoginPage;
import pages.LoginPage_PageFactory;
import pages.MenuPage;
import pages.HomePage;

public class BaseTest extends frmwrk.testbase.BaseTest {

	public AdminPage adminPage;
	public LoginPage loginPage;
	public MenuPage menuPage;
	public HomePage homePage;

	public int standardInitialWaitTimeOut = 5000;
	public int exerciseSBUTTimeTimeOut = 69000;
	public int exercise6MWTimeout = 360000;

	public String username = "";
	public String password = "";

	@BeforeMethod(alwaysRun = true)
	public void before() {
		adminPage = new AdminPage();
		loginPage = new LoginPage();
		menuPage = new MenuPage();
		homePage = new HomePage();

		DriverManager.getDriver().get("https://dosp-hsx-uat.crm4.dynamics.com/");

	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {
		//DriverManager.KillDriver();
	}
	
	public void login(String email, String password) {
		loginPage.loginWithAdmin();
		loginPage.stayLoggedIn(false);
	}

}
