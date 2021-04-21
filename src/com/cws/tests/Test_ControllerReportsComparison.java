package com.cws.tests;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.page_objects.ControllerReports_Comparison;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_ControllerReportsComparison extends ControllerReports_Comparison {
	
	ExtentTest result;

	public void navigateToReport() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Navigating to comparison
		comparison().click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Selecting Report Type
		Select reportTypeDropdown = new Select(reportType());
		reportTypeDropdown.selectByIndex(1);
		result.log(Status.PASS, "Selected Report Type: Estimate.");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Selecting a From date
		Select fromDropdown;
		try {
			fromDropdown = new Select(from());
		} catch (StaleElementReferenceException e) {
			fromDropdown = new Select(from());
			fromDropdown.selectByIndex(1);
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		result.log(Status.PASS, "Successfully generated the Report.");
	}

	public void clickOnExportToExcel() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exportToExcel().click();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		result.log(Status.PASS, "Clicked on Export to Excel.");
		result.log(Status.PASS, "Successfully exported the Extract.");

	}

	public void validateComparisonTab() {
		result = Reports.extent.createTest("Comparison", "Validate Comparison Report Page.");
		navigateToReport();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			clickOnExportToExcel();
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
	}
}
