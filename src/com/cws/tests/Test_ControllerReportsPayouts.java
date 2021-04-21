package com.cws.tests;

import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.page_objects.ControllerReports_Payouts;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_ControllerReportsPayouts extends ControllerReports_Payouts
{
	ExtentTest result; 
	public void  navigateToReport()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Expanding Controller's Report module
		expandControllersReports().click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Navigating to Payouts
		payouts().click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Selecting year
		Select yearDropdown = new Select(year());
		yearDropdown.selectByValue("2020");
		result.log(Status.PASS, "Selected Year: 2020");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Selecting Month
		Select monthDropdown = new Select(month());
		monthDropdown.selectByValue("01");
		result.log(Status.PASS, "Selected Month: 01");
		result.log(Status.PASS, "Successfully generated the Report.");
	}
	
	public void approveAndRemoveApproval()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//If the report is not approved
		if(status().getText().equals("Requires Approval"))
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Approving
			approve().click();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Removing Approval
			removeApproval().click();
		
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//If the report is already approved
		 if(status().getText().equals("Approved"))
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Removing Approval
			removeApproval().click();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Approving
			approve().click();

		}
	}
	
	public void clickOnExportToExcel()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		exportToExcel().click();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		result.log(Status.PASS, "Clicked on Export button.");
		result.log(Status.PASS, "Successfully downlaoded the extract.");
		
	}
	

	public void validatePayoutsTab() {
		result = Reports.extent.createTest("Payouts", "Validate Payouts Page.");
		navigateToReport();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		approveAndRemoveApproval();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			clickOnExportToExcel();	
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
	}
}
