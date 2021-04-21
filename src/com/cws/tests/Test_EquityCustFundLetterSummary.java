package com.cws.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.HistoryCustFundLetterSummary;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_EquityCustFundLetterSummary extends HistoryCustFundLetterSummary {

	CommonFunctions cf = new CommonFunctions();
	ExtentTest result;

	public void exportToExcel() {
		getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnExport']")).click();
		cf.sleepWait(3000);
	}

	public void validate_equityCustFundLetterSummaryPage() {
		result = Reports.extent.createTest("Equity Custody Funding Letter Summary", "Validate Custody Funding Letter Summary page");
		histCustFundLetterSummaryTab().click();
		cf.sleepWait(1000);

		//Select date.
		Select date = new Select(getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlHistory']")));
		String dateVal = "2020/09/29";
		date.selectByValue(dateVal);
		result.log(Status.PASS, "Selected Date as: "+dateVal);
		cf.sleepWait(1500);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		/*
		//Select custodian.
		Select custodian = new Select(custodianDropdown());
		custodian.selectByValue("CIT");
		cf.sleepWait(1000);
		*/

		result.log(Status.PASS, "Successfully generated the Report");
		//Export report data.
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			exportToExcel();
			result.log(Status.PASS, "Successfully extracted the Report");
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
	}

}
