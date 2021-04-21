package com.cws.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.HistoryCustFundingLetterQC;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_EquityCustFundingLetterQC extends HistoryCustFundingLetterQC {

	CommonFunctions cf = new CommonFunctions();
	ExtentTest result;

	public void validate_equityCustFundingLetterQC() {
		result = Reports.extent.createTest("Equity Custody Funding Letter QC", "Validate Custody Funding Letter QC page");
		histCustFundLetterQCTab().click();
		cf.sleepWait(3000);

		// Select date.
		Select date = new Select(getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlHistory']")));
		String dateVal = "2020/09/29";
		date.selectByValue(dateVal);
		result.log(Status.PASS, "Selected Date as: "+dateVal);
		cf.sleepWait(1500);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		result.log(Status.PASS, "Successfully generated the Report");

		// Select portfolio.
		Select portfolio = new Select(getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlPortfolio']")));
		String portfolioValue = "Multi-Index Lifestyle Moderate Portfolio                                   ";
		portfolio.selectByValue(portfolioValue);
		result.log(Status.PASS, "Selected Portfolio as: "+portfolioValue);
		cf.sleepWait(3000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		//Click Record Date QC
		getDriver().findElement(By.xpath("//span[contains(text(),'Record Date QC')]")).click();
		cf.sleepWait(1500);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		result.log(Status.PASS, "Clicked Record Date QC");
		result.log(Status.PASS, "Report successfully displayed for Record Date QC");
		
		//Click Total Dividend QC
		getDriver().findElement(By.xpath("//span[contains(text(),'Total Dividend QC')]")).click();
		cf.sleepWait(1500);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		result.log(Status.PASS, "Clicked Total Dividend QC");
		result.log(Status.PASS, "Report successfully displayed for Total Dividend QC");
		
		//Click Total Reinvestment QC
		getDriver().findElement(By.xpath("//span[contains(text(),'Total Reinvestment QC')]")).click();
		cf.sleepWait(1500);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		result.log(Status.PASS, "Clicked Total Reinvestment QC");
		result.log(Status.PASS, "Report successfully displayed for Total Reinvestment QC");
		
		//Click Cash QC
		getDriver().findElement(By.xpath("//span[contains(text(),'Cash QC')]")).click();
		cf.sleepWait(1500);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		result.log(Status.PASS, "Clicked Cash QC");
		result.log(Status.PASS, "Report successfully displayed for Cash QC");

		//Click Export
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnExport']")).click();
			cf.sleepWait(1500);
			result.log(Status.PASS, "Successfully extracted the Report");
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		
	}

}
