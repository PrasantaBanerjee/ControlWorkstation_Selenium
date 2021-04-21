package com.cws.tests;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.DailyAccrual;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_DailyAccrual extends DailyAccrual {

	CommonFunctions cf = new CommonFunctions();
	ExtentTest dailyAccrual;

	public int getRandomNumberUsingNextInt(int userMin, int userMax) {
		Random random = new Random();
		int finalValue = (random.nextInt(userMax - userMin) + userMin + 3) + (random.nextInt(userMax - userMin) + userMin + 1);
		return finalValue;
	}

	public void validate_dailyAccrualPage() {
		dailyAccrual = Reports.extent.createTest("Daily Accrual", "Validate Daily Accrual Report");
		cf.sleepWait(1000);
		dailyAccrualProcessFolder().click();
		cf.sleepWait(1000);
		dailyAccrualTab().click();
		cf.sleepWait(1000);
		Select portfolio = new Select(portfolioDropdown());
		portfolio.selectByValue("High Yield");
		dailyAccrual.log(Status.PASS, "Selected Portfolio: High Yield");
		cf.sleepWait(1000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		boolean bankAccrualIsPresent = false;
		try {
			if (bankAccrualTableTab().isDisplayed()) {
				bankAccrualIsPresent = true;
			}
		} catch (NoSuchElementException e) {
			bankAccrualIsPresent = false;
		}

		if (bankAccrualIsPresent == true) {
			bankAccrualTableTab().click();
			cf.sleepWait(1000);
			dailyAccrual.log(Status.PASS, "Clicked on Bank Accrual column");
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			String newValue=Integer.toString(getRandomNumberUsingNextInt(1000, 765432));
			amountTextbox().sendKeys(newValue);
			dailyAccrual.log(Status.PASS, "Changed value to: "+newValue);
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			Select reasons = new Select(reasonsDropdown());
			reasons.selectByVisibleText("Incorrect Accrual");
			dailyAccrual.log(Status.PASS, "Selected reason: Incorrect Accrual");
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			okBtn().click();
			dailyAccrual.log(Status.PASS, "Clicked on OK Button");
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			cf.sleepWait(1000);
		}

		boolean accrualAdjIsPresent = false;
		try {
			if (accrualAdjustmentTab().isDisplayed()) {
				accrualAdjIsPresent = true;
			}
		} catch (NoSuchElementException e) {
			accrualAdjIsPresent = false;
		}

		if (accrualAdjIsPresent == true) {
			accrualAdjustmentTab().click();
			cf.sleepWait(1000);
			dailyAccrual.log(Status.PASS, "Clicked on Accrual Adjustment tab");
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			String newValue=Integer.toString(getRandomNumberUsingNextInt(2, 99));
			amountTextbox().sendKeys(newValue);
			dailyAccrual.log(Status.PASS, "Changed value to: "+newValue);
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			Select reasons = new Select(reasonsDropdown());
			reasons.selectByVisibleText("Bad Rate");
			dailyAccrual.log(Status.PASS, "Selected reason: Bad Rate");
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			okBtn().click();
			dailyAccrual.log(Status.PASS, "Clicked on OK Button");
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
			cf.sleepWait(1000);
		}

		submitBtn().click();
		cf.sleepWait(1000);
		dailyAccrual.log(Status.PASS, "Clicked on Submit button");
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		
		closeBtn().click();
		cf.sleepWait(1000);
		dailyAccrual.log(Status.PASS, "Clicked on Close button");
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		recalculateBtn().click();
		cf.sleepWait(1000);
		dailyAccrual.log(Status.PASS, "Clicked on Re-Calculate button");
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		
		closeBtn().click();
		cf.sleepWait(1000);
		dailyAccrual.log(Status.PASS, "Clicked on Close button");
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		showAdjustmentsBtn().click();
		cf.sleepWait(1000);
		dailyAccrual.log(Status.PASS, "Clicked on Show Adjustments button");
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		getDriver().switchTo().frame(showAdjustmentsFrame());

		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			showAdjustmentsExportBtn().click();
			cf.sleepWait(3000);
			dailyAccrual.log(Status.PASS, "Clicked on Export to Excel button");
			dailyAccrual.log(Status.PASS, "Successfully extracted the Show Adjustments data");
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		}

		getDriver().switchTo().defaultContent();

		getDriver().findElement(By.xpath("(//img[@mkr='Close'])[2]")).click();
		cf.sleepWait(1000);
		dailyAccrual.log(Status.PASS, "Clicked on Close button");
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			exportBtn().click();
			cf.sleepWait(3000);
			dailyAccrual.log(Status.PASS, "Clicked on Export to Excel button");
			dailyAccrual.log(Status.PASS, "Successfully extracted the Daily Accrual data");
			Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		}

		cancelBtn().click();
		cf.sleepWait(1000);
		dailyAccrual.log(Status.PASS, "Clicked on Cancel button");
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

	}
}
