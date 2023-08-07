package elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import frmwrk.locators.Locator;
import frmwrk.reporters.Log;

public class DatePickerField extends BaseElement {
	
	protected By by;
	
	private String datePickerXpath = "//div[contains(@id, 'DatePicker-Callout')]";
	private String monthPickerXpath = datePickerXpath + "//div[contains(@class,'monthPickerWrapper')]";
	
	private Button btnMonthAndYear = new Button(By.xpath(datePickerXpath + "//*[contains(@class,'monthAndYear') and @type='button']"));
	
	private BaseElement divMonthPicker = new BaseElement(By.xpath(monthPickerXpath));
	private Button btnCurrentYear = new Button(By.xpath(monthPickerXpath + "//button[contains(@class,'currentItemButton')]/span"));
	private Button btnPrevYear = new Button(By.xpath(monthPickerXpath + "//div[contains(@class,'navigationButtonsContainer')]/button/i[@data-icon-name='Up']"));
	private Button btnNextYear = new Button(By.xpath(monthPickerXpath + "//div[contains(@class,'navigationButtonsContainer')]/button/i[@data-icon-name='Down']"));
	
	
	public DatePickerField(Locator locator) {
		super(locator);
		by = locator.getLocator();
	}
	
	public DatePickerField(By by) {
		super(by);
		this.by = by;
	}
	
	
	public void setDateInField(String date) {
		Log.debug("Setting the date to '" + date + "' on element " + by.toString());
		Field field = new Field(by);
		field.setText(date);
		Log.debug("Date has been set in the element");
	}

	/**
	 * Setting the date.
	 * @param date given in dd/MM/YYYY format
	 */
	public void setDateByUsingDatePicker(String date) {
		Log.debug("Setting the date to '" + date + "' on element " + by.toString());
		
		Date requestedDate = null;
		try {
			requestedDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		waitUntilElementIsPresent(by, defaultTimeOut);
		waitUntilElementIsVisible(by, defaultTimeOut);
		
		Field dateField = new Field(by);
		
		dateField.click();
		btnMonthAndYear.waitUntilElementIsVisible(defaultTimeOut);
		
		//Check if the big datepicker view is available (which is quicker)'
		if (!divMonthPicker.isElementVisible(2000)) {
			btnMonthAndYear.click();
		}
			
		btnCurrentYear.waitUntilElementIsVisible(defaultTimeOut);
		
		SimpleDateFormat requestedDateYear = new SimpleDateFormat("yyyy");
		setYear(Integer.parseInt(requestedDateYear.format(requestedDate)));
		
		SimpleDateFormat requestedDateMonth = new SimpleDateFormat("MM");
		setMonth(Integer.parseInt(requestedDateMonth.format(requestedDate)));
		
		SimpleDateFormat requestedDateDay = new SimpleDateFormat("dd");
		setDay(Integer.parseInt(requestedDateDay.format(requestedDate)));	
	}
	
	
	private void setYear(int year) {
		Log.debug("Setting the year to: " + year);
		
		boolean yearSelected = false;
		do {
			int selectedYear = Integer.parseInt(btnCurrentYear.getText());
			if (selectedYear == year){
				yearSelected = true;
				Log.debug("Year is correctly selected");
			} else if (selectedYear < year) {
				Log.debug("Selected year ("+ selectedYear + ") is lower then requested year (" + year + "). Clicking on the next button.");
				btnNextYear.click();				
			} else {
				Log.debug("Selected year ("+ selectedYear + ") is higher then requested year (" + year + "). Clicking on the previous button.");
				btnPrevYear.click();	
			}
			waitForMilliseconds(500);
		} while (!yearSelected);		
		Log.debug("Correct year selected");	
	}
	
	private void setMonth(int month) {
		Log.debug("Setting the month to: " + month);
		
		List <WebElement> months = getWebElements(By.xpath(monthPickerXpath + "//div[contains(@class,'gridContainer')]//button"));
		WebElement monthToSelect = months.get(month-1);
		monthToSelect.click();
		
		Log.debug("Correct month selected");	
	}
	
	private void setDay(int day) {
		Log.debug("Setting the day to: " + day);
		
		List <WebElement> days = getWebElements(By.xpath(datePickerXpath + "//tr[contains(@class, 'weekRow')]//span[text() = '"+ day +"']"));
		WebElement dayToSelect = null;
		if (day < 15) {
			dayToSelect = days.get(0);
		} else {
			dayToSelect = days.get(days.size()-1);
		}
		dayToSelect.click();
		
		Log.debug("Correct day selected");	
	}
	
	
	
	
	
	

	

}
