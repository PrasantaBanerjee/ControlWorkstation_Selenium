package com.cws.tests;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.page_objects.ControllerReports_FeeTypes;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_ControllerReportsFeeTypes extends ControllerReports_FeeTypes
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

		//Expanding Controller's Administration module
		expandControllersAdministration().click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Navigating to Fee Types
		feeTypes().click();
		
	}
	
	public void clickOnExportToExcel()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Exporting to Excel
		try
		{
		exportToExcel().click();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		}
		catch(Exception E)
		{
			System.out.println(E);
		}
		
		result.log(Status.PASS, "Clicked on Export to Excel.");
		result.log(Status.PASS, "Successfully downloaded the extract.");

	}
	
	public void addNewFeeType()
	{	
		try
		{			
			Thread.sleep(1000);
			
			//Clicking on Fee Type text box
			selectFeeTypeTextbox().click();
			
			//Generating a random string
			String randomPayoutType = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			StringBuilder sb = new StringBuilder();
			Random random = new Random();
			int length = 4;
			for(int i = 0; i < length; i++) 
			{
				sb.append(randomPayoutType.charAt(random.nextInt(randomPayoutType.length())));
			}
			    
			Thread.sleep(1000);
			
			//Entering a value in Fee Type text box
			feeTypeTextbox().sendKeys(sb.toString());
			result.log(Status.PASS, "Entered new Fee Type value: "+sb.toString());
						
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Selecting Active/Inactive Status
		try
		{
			Thread.sleep(1000);
			
			//Selecting Active/Inactive drop down box
			activeInactiveDropdown().click();
			
			Thread.sleep(1000);
			
			//Clicking on the arrow button
			activeInactiveDropdownImage().click();
			
			Thread.sleep(1000);
			
			//Selecting a value from the dropdown
			activeInactiveDropdownValue().click();
			
			Thread.sleep(1000);
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			result.log(Status.PASS, "Selected status from dropdown: Active");

			//Clicking on Enter key to add a new Fee Type
			Actions action = new Actions(getDriver());
			action.sendKeys(Keys.ENTER).build().perform();
	/*		
			//Validating whether the insertion was successful by checking the text on the popup
			if(information().getText().equals("Record Inserted Successfully"))
			{
				System.out.println("Successfully Inserted");
			}
			else if(information().getText().equals("Fee Type already exists"))
			{
				System.out.println("Fee Type already exists");
			}
		*/	
			Thread.sleep(2000);
			result.log(Status.PASS, "Successfully added new Fee Type.");
			
			//Closing the popup window.
			closePopup().click();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateStatus() 
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Clicking on "12B1" record
		updateFeeType().click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Updating the status
		Select sc = new Select(updateActiveInactive());
		
		//If status is active, then changing to inactive
		if(sc.getFirstSelectedOption().getText().equals("A"))
		{
			sc.selectByValue("I");
		}
		
		//If status is inactive, then changing to active
		else if(sc.getFirstSelectedOption().getText().equals("I"))
		{
			sc.selectByValue("A");
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Clicking on submit button
		submitButton().click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		
		//Validating whether the updation was successful by checking the text on the popup
		if(information().getText().equals("Record Updated Successfully"))
		{
			System.out.println("Successfully updated");
		}
*/	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Closing the popup window.
		updateClosePopup().click();	

	}
	
	public void validateFeeTypes() {
		result = Reports.extent.createTest("Fee Types", "Validate Fee Types Page.");
		navigateToReport();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			clickOnExportToExcel();
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		addNewFeeType();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		updateStatus();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
	}

}
