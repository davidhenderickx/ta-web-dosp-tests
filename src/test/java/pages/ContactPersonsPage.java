package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import elements.Button;
import elements.Combobox;
import elements.DatePickerField;
import elements.Field;
import elements.SearchField;
import frmwrk.drivers.DriverManager;
import frmwrk.reporters.Log;


public class ContactPersonsPage extends BasePage {
	
	Button btnNewContactPerson = new Button(By.xpath("//button[@data-id='contact|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.contact.NewRecord']"));
	
	Field fldFirstName = new Field(By.xpath("//input[@data-id='firstname.fieldControl-text-box-text']"));
	Field fldLastName = new Field(By.xpath("//input[@data-id='lastname.fieldControl-text-box-text']"));
	Combobox cbxLanguage = new Combobox(By.xpath("//select[@data-id='dosp_language.fieldControl-option-set-select']"));
	Field fldEmail = new Field(By.xpath("//input[@data-id='emailaddress1.fieldControl-mail-text-input']"));
	Field fldEmployeeNumber = new Field(By.xpath("//input[@data-id='dosp_employeenumber.fieldControl-text-box-text']"));
	Field fldJobTitle = new Field(By.xpath("//input[@data-id='jobtitle.fieldControl-text-box-text']"));
	SearchField fldAccount = new SearchField(By.xpath("//input[@data-id='dosp_employeenumber.fieldControl-text-box-text']"));
	Field fldTelephone = new Field(By.xpath("//input[@data-id='telephone1.fieldControl-phone-text-input']"));
	Field fldMobilePhone = new Field(By.xpath("//input[@data-id='mobilephone.fieldControl-phone-text-input']"));
	Field fldSalutation = new Field(By.xpath("//input[@data-id='salutation.fieldControl-text-box-text']"));
	DatePickerField dpfldFrom = new DatePickerField(By.xpath("//input[@data-id='dosp_from.fieldControl-date-time-input']"));
	DatePickerField dpfldTo = new DatePickerField(By.xpath("//input[@data-id='dosp_until.fieldControl-date-time-input']"));
	
	Button btnSaveNewContactPerson = new Button(By.xpath("//button[@data-id='contact|NoRelationship|Form|Mscrm.Form.contact.Save']"));
	Button btnSaveAndCloseNewContactPerson = new Button(By.xpath("//button[@data-id='contact|NoRelationship|Form|Mscrm.Form.contact.SaveAndClose']"));
	
	
	public boolean isShown() {
		Log.info("Checking if the contact persons page is visible");
		return btnNewContactPerson.isElementVisible();
	}
	
	public void openNewContactPersonForm() {
		Log.info("Opening the new contact person form");
		btnNewContactPerson.click();
	}
	
	public void fillInNewContactPersonForm() {
		Log.info("Filling in the new contact person form");
		fldFirstName.setText("David");
		fldLastName.setText("Henderickx");
		cbxLanguage.selectByVisibleText("Nederlands");
		fldEmail.setText("ctgtesting@yopmail.com");
		fldEmployeeNumber.setText("1503");
		fldJobTitle.setText("Test Automation Dummy");
		fldTelephone.setText("03888123458");
		fldMobilePhone.setText("0494474747");
		fldSalutation.setText("Mr.");
		dpfldFrom.setDateByUsingDatePicker("05/03/2021");
		
	}
	
	public void saveNewContactPerson() {
		Log.info("Saving the new contact person");
		btnSaveNewContactPerson.click();
	}
	
	public void saveAndCloseNewContactPerson() {
		Log.info("Saving and closing the new contact person ");
		btnSaveAndCloseNewContactPerson.click();
	}
	
	

}
