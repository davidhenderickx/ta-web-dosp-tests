package tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import frmwrk.enums.Environment;
import frmwrk.settings.RunSettings;

public class LoginTests extends BaseTest {
 
    

	@Test(priority = 1, description = "Log in with correct username and password")
	public void loggingInWithCorrectUsernamePassword(Method method) {
		loginPage.loginWithAdmin();
		//Assert.assertTrue(welcomePage.isWelcomeMessageDisplayed(),"The Welcome message is not shown");
	}

	
}