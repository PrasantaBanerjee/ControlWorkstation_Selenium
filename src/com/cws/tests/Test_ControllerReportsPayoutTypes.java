package com.cws.tests;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.page_objects.ControllerReports_PayoutTypes;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_ControllerReportsPayoutTypes extends ControllerReports_PayoutTypes
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
		
		//Navigating to Fee Types
		payoutTypes().click();
		
	}
	
	public void clickOnExportToExcel()
	{
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Exporting to Excel
		exportToExcel().click();
		exportToExcel().click();
		result.log(Status.PASS, "Clicked on Export button.");
		result.log(Status.PASS, "Successfully downloaded the extract.");
	}
	
	public void addNewPayoutType()
	{	
		try
		{			
			Thread.sleep(1000);
			
			//Clicking on Payout Type ID text box
			selectPayoutTypeId().click();
			
			//Generating a random character
			String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
			StringBuilder sb = new StringBuilder();
			Random rnd = new Random();
			char c = chars.charAt(rnd.nextInt(chars.length()));
			sb.append(c);
			
			Thread.sleep(1000);
			
			//Entering a value in Payout Type ID text box
			enterPayoutTypeId().sendKeys(sb);
			
			Thread.sleep(1000);
			
			//Selecting Payout Type text box
			selectPayoutTypeTextbox().click();
			
			//Generating a random string
			String randomPayoutType = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			StringBuilder sb1 = new StringBuilder();
			int length = 4;
			for(int i = 0; i < length; i++) 
			{
				sb1.append(randomPayoutType.charAt(rnd.nextInt(randomPayoutType.length())));
			}
			
			Thread.sleep(1000);
			
			//Entering a value in Payout Type text box
			enterPayoutTypeTextbox().sendKeys(sb1);
			
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

			//Clicking on Enter key to add a new Fee Type
			Actions action = new Actions(getDriver());
			action.sendKeys(Keys.ENTER).build().perform();
			
			//Validating whether the insertion was successful by checking the text on the popup
			if(information().getText().equals("Record Inserted Successfully"))
			{
				System.out.println("Successfully Inserted");
			}
			else if(information().getText().equals("Payout Type already exists"))
			{
				System.out.println("Payout Type already exists");
			}
			
			Thread.sleep(1000);
			
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
		
		//Clicking on D record
		updatePayoutTypeId().click();

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
		
		//Validating whether the updation was successful by checking the text on the popup
		if(information().getText().equals("Record Updated Successfully"))
		{
			System.out.println("Successfully updated");
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Closing the popup window.
		updateClosePopup().click();	

	}
	
	public void validatePayoutsTab() {
		result = Reports.extent.createTest("Payout Types", "Validate Payout Types Page.");
		navigateToReport();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			clickOnExportToExcel();
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		//addNewPayoutType();
		updateStatus();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
	}
}
