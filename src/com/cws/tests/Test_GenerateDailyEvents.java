package com.cws.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.GenerateDailyEvents;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_GenerateDailyEvents extends GenerateDailyEvents {
	
	CommonFunctions cf = new CommonFunctions();
	ExtentTest generateEvents;
	
	public void validate_generateDailyEventsPage() {
		generateEvents = Reports.extent.createTest("Generate Daily Events", "Validate Generate Daily Events page");
		generateDailyEventsTab().click();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		Select year = new Select(yearDropdown());
		year.selectByValue("2021");
		generateEvents.log(Status.PASS, "Selected Year: 2021");
		
		generateBtn().click();
		cf.sleepWait(1000);
		generateEvents.log(Status.PASS, "Clicked on Generate button.");
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		
		String message = getDriver().findElement(By.xpath("//span[@class='Information']")).getText();
		generateEvents.log(Status.PASS, "Message displayed as: "+ message);
		
		closeBtn().click();
		generateEvents.log(Status.PASS, "Clicked on Close button.");
	}

}
