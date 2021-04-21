package com.cws.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.page_objects.ControllerReports_FeePayoutTypes;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_ControllerReportsFeePayoutTypes extends ControllerReports_FeePayoutTypes
{
	ExtentTest result;
		
	public void  navigateToReport()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Navigating to Fee Types
		feePayoutTypes().click();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
	}
	
	public void clickOnExportToExcel()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Exporting to Excel
		exportToExcel().click();
		exportToExcel().click();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		result.log(Status.PASS, "Clicked on Export button.");
		result.log(Status.PASS, "Successfully exported the sheet.");
	}
	
	public void add()
	{	
		try
		{			
			Thread.sleep(1000);
			
			//Selecting Fee Type text box
			feeType().click();
			
			Thread.sleep(1000);
			
			//Clicking on the arrow button
			feeTypeDropdown().click();
			
			Thread.sleep(1000);
			
			//Selecting a value from the dropdown
			feeTypeDropdownSelect().click();
			result.log(Status.PASS, "Selected Fee Type from dropdown.");
			
			Thread.sleep(1000);
			
			//Selecting Payout Type drop down box
			payoutType().click();
			result.log(Status.PASS, "Selected Payout Type from dropdown.");
			
			Thread.sleep(1000);
			
			//Clicking on the arrow button
			payoutTypeDropdown().click();
			
			Thread.sleep(1000);
			
			//Selecting a value from the dropdown
			payoutTypeDropdownSelect().click();
			
			Thread.sleep(1000);
			
			//Selecting Active/Inactive drop down box
			activeInactive().click();
			result.log(Status.PASS, "Selected status for new Fee Payout type.");
			
			Thread.sleep(1000);
			
			//Clicking on the arrow button
			activeInactiveDropdown().click();
			
			Thread.sleep(1000);
			
			//Selecting a value from the dropdown
			activeInactiveDropdownSelect().click();
			
			Thread.sleep(1000);
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			//Clicking on Enter key to add a new Fee Type
			Actions action = new Actions(getDriver());
			action.sendKeys(Keys.ENTER).build().perform();
	/*		
			//Validating whether the insertion was successful by checking the text on the popup
			if(information().getText().equals("Record Inserted Successfully"))
			{
				System.out.println("Successfully Inserted");
			}
			else if(information().getText().equals("Fee Type & Payout Type Relationship already exists"))
			{
				System.out.println("Fee Type & Payout Type Relationship already exist");
			}
		*/	
			Thread.sleep(1000);
			
			result.log(Status.PASS, "Successfully added Fee Payout Type.");
			
			//Closing the popup window.
			updateClosePopup().click();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void validateFeePayoutTypesTab() 
	{
		result = Reports.extent.createTest("Fee Payout Types", "Validate Fee Payout Types Page.");
		navigateToReport();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			clickOnExportToExcel();
		}
		add();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
	}
}
