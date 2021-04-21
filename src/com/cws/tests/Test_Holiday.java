package com.cws.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.cws.commons.CommonFunctions;
import com.cws.page_objects.Holiday;

public class Test_Holiday extends Holiday {
	
	CommonFunctions cf = new CommonFunctions();

	public void openHolidayPage() {
		administrationFolder().click();
		cf.sleepWait(1500);
		holidayTab().click();
	}
	
	//Date format should be 'mm/dd/yyyy'
	public void addHoliday(String dateValue) {
		holidayDate().click();
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].value='" + dateValue + "';", holidayDate());
		holidayDate().sendKeys(dateValue);
		cf.sleepWait(1500);
		Actions act = new Actions(getDriver());
		act.sendKeys(Keys.ENTER).build().perform();
		cf.sleepWait(1500);
	}
	
	public void validate_holidayPage() {
		openHolidayPage();
		cf.sleepWait(2000);
		//addHoliday("10/10/2020");
	}
}
