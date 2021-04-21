package com.cws.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.HistoryCustFundLetterSummary;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_HistoryCustFundLetterSummary extends HistoryCustFundLetterSummary {

	CommonFunctions cf = new CommonFunctions();
	ExtentTest result;

	public void exportToExcel() {
		getDriver().findElement(By.xpath("//input[@type='submit']")).click();
		cf.sleepWait(3000);
	}

	public void validate_custFundLetterSummaryPage() {
		result = Reports.extent.createTest("History Custody Funding Letter Summary", "Validate History Custody Funding Letter Summary page");
		histCustFundLetterSummaryTab().click();
		cf.sleepWait(1000);

		//Select date.
		Select date = new Select(getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlhistory']")));
		String dateValue="2020/09/30";
		date.selectByValue(dateValue);
		result.log(Status.PASS, "Selected Date: "+dateValue);
		cf.sleepWait(1000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		//Select custodian.
		Select custodian = new Select(custodianDropdown());
		String custVal = "CIT";
		custodian.selectByValue(custVal);
		result.log(Status.PASS, "Selected Custodian: "+custVal);
		cf.sleepWait(1000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		//Export report data.
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			exportToExcel();
			result.log(Status.PASS, "Successfully extracted the Report");
		}
		
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
	}

}
