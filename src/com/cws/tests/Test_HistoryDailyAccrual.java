package com.cws.tests;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.HistoryDailyAccrual;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_HistoryDailyAccrual extends HistoryDailyAccrual {

	CommonFunctions cf = new CommonFunctions();
	ExtentTest result;

	public int getRandomNumberUsingNextInt(int userMin, int userMax) {
		Random random = new Random();
		int finalValue = (random.nextInt(userMax - userMin) + userMin + 3) + (random.nextInt(userMax - userMin) + userMin + 1); 
		return finalValue;
	}

	public void validate_AccrualPage() {
		result = Reports.extent.createTest("History Daily Accrual", "Validate History Daily Accrual page");	
		historyFolder().click();
		cf.sleepWait(1000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		dailyHistoryFolder().click();
		cf.sleepWait(1000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		dailyAccrualTab().click();
		cf.sleepWait(1000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		//Select date.
		Select date = new Select(getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlHistory']")));
		String dateVal = "2020/06/30";
		date.selectByValue(dateVal);
		result.log(Status.PASS, "Selected Date: "+dateVal);
		cf.sleepWait(3000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		//Select portfolio.
		Select portfolio = new Select(portfolioDropdown());
		String portfolioValue = "High Yield";
		portfolio.selectByValue(portfolioValue);
		result.log(Status.PASS, "Selected Portfolio: "+portfolioValue);
		cf.sleepWait(3000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		//Click show adjustments button.	
		showAdjustmentsBtn().click();
		cf.sleepWait(1000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		result.log(Status.PASS, "Clicked on Show Adjustments button");

		getDriver().switchTo().frame(showAdjustmentsFrame());

		//Click export button.
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			showAdjustmentsExportBtn().click();
			cf.sleepWait(3000);
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			result.log(Status.PASS, "Clicked on Export to Excel button");
			result.log(Status.PASS, "Successfully extracted the Show Adjustments data");
		}

		getDriver().switchTo().defaultContent();

		//Click close button.
		getDriver().findElement(By.xpath("(//img[@mkr='Close'])[2]")).click();
		cf.sleepWait(1000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		result.log(Status.PASS, "Clicked on Close button");

		//Click export button.
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			exportBtn().click();
			cf.sleepWait(3000);
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			result.log(Status.PASS, "Clicked on Export to Excel button");
			result.log(Status.PASS, "Successfully extracted the History Daily Accrual data");
		}

		//Click cancel button.
		cancelBtn().click();
		cf.sleepWait(1000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		result.log(Status.PASS, "Clicked on Cancel button");
	}
	
	public void validate_historyDailyAccrualPage() {
		validate_AccrualPage();

	}

}
