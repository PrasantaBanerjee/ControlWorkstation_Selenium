package com.cws.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.HistoryDivT;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_HistoryDivT extends HistoryDivT {
	CommonFunctions cf = new CommonFunctions();
	ExtentTest result;

	public void validate_histDivTPage() {
		result = Reports.extent.createTest("History Div-T", "Validate History Div-T page");
		histDivTTab().click();
		cf.sleepWait(1000);

		//Select date.
		Select date = new Select(getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlHistory']")));
		String dateValue = "2020/09/30";
		date.selectByValue(dateValue);
		result.log(Status.PASS, "Selected Date: "+dateValue);
		cf.sleepWait(1000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		//Select DDA.
		Select dda = new Select(DDADropdown());
		String ddaValue = "8900588179";
		dda.selectByValue(ddaValue);
		result.log(Status.PASS, "Selected DDA: "+ddaValue);
		cf.sleepWait(1000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		//Export report data.
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnExport']")).click();
			cf.sleepWait(3000);
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			result.log(Status.PASS, "Clicked on Export button");
			result.log(Status.PASS, "Successfully extracted the Report");
		}

		//Click cancel button.
		getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnCancel']")).click();
		cf.sleepWait(500);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		result.log(Status.PASS, "Clicked on Cancel button");
	}
}
