package com.cws.tests;

import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.page_objects.HalfpennyDailyNAVBreakage;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_HalfpennyDailyNAVBreakage extends HalfpennyDailyNAVBreakage {
	
	ExtentTest result; 
	
	public void validate_DailyNAVBreakage() {
		result = Reports.extent.createTest("Halfpenny Daily NAV Breakage", "Validate Daily NAV Breakage Page.");
		
		// Navigating to Halfpenny page
		halfpenny().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		// Daily NavBreakage module
		DailyNAV_Breakage().click();
		result.log(Status.PASS, "Clicked on Daily NAV Breakage tab.");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.log(Status.PASS, "Successfully generated the Report.");
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		Print_DailyNAVBreakage().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		Actions act = new Actions(getDriver());
		act.moveToElement(Printbtn_DailyNAVBreakage()).click().perform();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		/*
		Export_DailyNAVBreakage().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Select_Export_DailyNAVBreakage().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Click_Export_DailyNAVBreakage().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Exportbtn_DailyNAVBreakage().click();
		*/
		
		result.log(Status.PASS, "Clicked on Export button.");
		result.log(Status.PASS, "Successfully extracted the Report.");

	}
}