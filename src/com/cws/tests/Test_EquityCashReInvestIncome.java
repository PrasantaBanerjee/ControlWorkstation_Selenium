package com.cws.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.CashReInvestIncome;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_EquityCashReInvestIncome extends CashReInvestIncome {

	CommonFunctions cf = new CommonFunctions();
	ExtentTest result;

	public void exportToPDF() {
		cf.sleepWait(3000);
		// Click 'Export this Report' button.
		getDriver().findElement(By.xpath("//img[@alt='Export this report']")).click();
		cf.sleepWait(1500);
		// Click 'RPT' Option drop down.
		getDriver().findElement(By.xpath("//div[contains(text(),'Crystal Reports (RPT)')]")).click();
		cf.sleepWait(1500);
		// Click 'PDF' Format.
		getDriver().findElement(By.xpath("//span[@title='PDF']")).click();
		cf.sleepWait(1500);
		// Click 'Export' button.
		getDriver().findElement(By.xpath("//a[contains(text(),'Export')]")).click();
		cf.sleepWait(1500);
	}

	public void validate_eqCashReinvestIncomePage() {
		result = Reports.extent.createTest("Equity Cash Re-Invest Income", "Validate Equity Cash Re-Invest Income page");
		try {
			equityHistoryTab().click();
		} catch(StaleElementReferenceException e) {
			equityHistoryTab().click();
		}
		
		cf.sleepWait(1500);
		cashReinvestIncomeTab().click();
		cf.sleepWait(1500);

		//Select date.
		Select date = new Select(getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlhistory']")));
		String dateVal = "2020/09/29";
		result.log(Status.PASS, "Selected Date as: "+dateVal);
		date.selectByValue(dateVal);
		cf.sleepWait(1500);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		//Export report data.
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			exportToPDF();
			result.log(Status.PASS, "Successfully extracted the Report");
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
	}

}
