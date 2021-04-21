package com.cws.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.page_objects.ControllerReports_BPS;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_ControllerReportsBPS extends ControllerReports_BPS {
	ExtentTest result;
	
	public void navigateToReport() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Navigating to Fee Types
		bps().click();

	}

	public void clickOnExportToExcel() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Exporting to Excel
		exportToExcel().click();
		result.log(Status.PASS, "Clicked on Export button.");
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		result.log(Status.PASS, "Successfully extracted the Report.");
	}

	public void add() {
		try {
			Thread.sleep(1000);

			// Selecting Fund Name text box
			fundName().click();
			Thread.sleep(1000);
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			result.log(Status.PASS, "Selected Fund Name from dropdown.");

			// Clicking on the arrow button
			fundNameDropdown().click();
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			Thread.sleep(1000);

			// Selecting a value from the dropdown
			fundNameDropdownSelect().click();
			Thread.sleep(1000);
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");

			// Selecting Fee Payout Relationship drop down box
			feePayoutRelationship().click();
			Thread.sleep(1000);
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			result.log(Status.PASS, "Selected Fee Payout relation from dropdown.");

			// Clicking on the arrow button
			feePayoutRelationshipDropdown().click();
			Thread.sleep(1000);
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");

			// Selecting a value from the dropdown
			feePayoutRelationshipDropdownSelect().click();
			Thread.sleep(1000);
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");

			// Selecting BPS text box
			bpsTextbox().click();
			Thread.sleep(1000);
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			
			// Clearing the value present
			bpsTextboxInput().clear();

			// Entering a value
			bpsTextbox().click();
			bpsTextboxInput().sendKeys("10");
			result.log(Status.PASS, "Entered value for BPS: 10");
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			Thread.sleep(1000);

			// Clicking on Enter key to add a new Fee Type
			Actions action = new Actions(getDriver());
			action.sendKeys(Keys.ENTER).build().perform();
			result.log(Status.PASS, "Successfully added new BPS for selected Fee Payout relation.");
			/*
			 * //Validating whether the insertion was successful by checking the text on the
			 * popup if(information().getText().equals("Record Inserted Successfully")) {
			 * System.out.println("Successfully Inserted"); } else
			 * if(information().getText().equals("BPS already exists")) {
			 * System.out.println("BPS already exists"); }
			 */
			Thread.sleep(1000);
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			
			// Closing the popup window.
			closePopup().click();
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateBPS() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Clicking on first record
		Actions a = new Actions(getDriver());
		a.doubleClick(updateFundName()).perform();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Updating the BPS
		updateBps().clear();
		updateBps().sendKeys("10");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Clicking on submit button
		submitButton().click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * //Validating whether the updation was successful by checking the text on the
		 * popup if(information().getText().equals("Record Updated Successfully")) {
		 * System.out.println("Successfully updated"); }
		 */
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Closing the popup window.
		updateClosePopup().click();

	}

	public void collapseTabs() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Collapse Controller's Administration module
		collapseControllersAdministration().click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Collapse Controller's Report module
		collapseControllersReports().click();
	}

	public void validateBPSTab() {
		result = Reports.extent.createTest("BPS", "Validate BPS Page.");
		navigateToReport();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			clickOnExportToExcel();
		}
		
		add();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		
		updateBPS();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		
		collapseTabs();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
