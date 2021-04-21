package com.cws.tests;

import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.ModifyEvents;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_ModifyEvents extends ModifyEvents {

	CommonFunctions cf = new CommonFunctions();
	ExtentTest modifyEvents;

	public void editShortTermCapGainCheckboxValue() {
		modifyEvents.log(Status.PASS, "Present Status: " + statusOfFund().getText());
		System.out.println("Present Status: " + statusOfFund().getText());
		
		Actions act = new Actions(getDriver());
		act.doubleClick(fund()).build().perform();
		System.out.println("Double-clicked on Fund: 4480");
		modifyEvents.log(Status.PASS,"Double-clicked on Fund: 4480"); 
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		cf.sleepWait(1000);
		
		//Check the box.
		shortTermCapGainCheckbox().click();
		System.out.println("Checked Short Term Cap Gain checkbox");
		modifyEvents.log(Status.PASS,"Checked Short Term Cap Gain checkbox"); 
		cf.sleepWait(1000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		
		okBtn().click();
		System.out.println("Clicked on OK Button.");
		modifyEvents.log(Status.PASS,"Clicked on OK Button."); 
		cf.sleepWait(1000);
		
		System.out.println("Status after editing: " + statusOfFund().getText());
		modifyEvents.log(Status.PASS,"Status after editing: " + statusOfFund().getText()); 
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		cf.sleepWait(1000);
		
		closeBtn().click();
		System.out.println("Clicked on Close Button.");
		modifyEvents.log(Status.PASS,"Clicked on Close Button."); 
		cf.sleepWait(1000);
		System.out.println();
		
	}
	
	public void editFundData() {
		modifyEventsTab().click();
		cf.sleepWait(1500);
		editShortTermCapGainCheckboxValue();
		cf.sleepWait(1000);
		editShortTermCapGainCheckboxValue();
		System.out.println("===========================================================================================");
	}
	
	public void exportToExcel() {
		exportBtn().click();
		cf.sleepWait(1000);
	}

	public void validate_modifyEventsPage() {
		modifyEvents= Reports.extent.createTest("Modify Events", "Validate Modify Events page");
		editFundData();
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			exportToExcel();
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			modifyEvents.log(Status.PASS,"Successfully extracted the Report."); 
		}
	}

}
