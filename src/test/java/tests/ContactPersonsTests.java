package tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import frmwrk.enums.Environment;
import frmwrk.settings.RunSettings;

public class ContactPersonsTests extends BaseTest {
 
    
	@Test(priority = 1, description = "Creating a new contact person")
	public void createNewContactPerson(Method method) {
		login(null, null);
		menuPage.ContactPersons();
		contactPersonsPage.isShown();
		contactPersonsPage.openNewContactPersonForm();
		contactPersonsPage.fillInNewContactPersonForm();
		
		
	}

	
}