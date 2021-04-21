package com.cws.tests;

import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.page_objects.HalfpennyDailyNAVBreakageHistory;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_HalfpennyDailyNAVBreakageHistory extends HalfpennyDailyNAVBreakageHistory {
	
	ExtentTest result;
	
	public void validate_DailyNAVBreakageHistory() {
		result = Reports.extent.createTest("Halfpenny Daily NAV Breakage History", "Validate Daily NAV Breakage History Page.");
		
		// Daily NavBreakage History module
		DailyNAV_History().click();
		result.log(Status.PASS, "Clicked on Daily NAV Breakage History tab.");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		result.log(Status.PASS, "Successfully generated the Report.");
		Print_DailyNAVHistory().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		Actions act = new Actions(getDriver());
		act.moveToElement(PrintBtn_DailyNAV_History()).click().perform();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		/*
		Export_DailyNAVHistory().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select_Export_DailyNAVBreakageHistory().click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Click_Export_DailyNAVBreakageHistory().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Exportbtn_DailyNAVHistory().click();
		*/
		
		result.log(Status.PASS, "Clicked on Export button.");
		result.log(Status.PASS, "Successfully extracted the Report.");
	}
}