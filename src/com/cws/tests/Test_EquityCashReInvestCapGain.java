package com.cws.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.CashReInvestCapGain;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_EquityCashReInvestCapGain extends CashReInvestCapGain {
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
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		// Click 'Export' button.
		getDriver().findElement(By.xpath("//a[contains(text(),'Export')]")).click();
		cf.sleepWait(1500);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
	}

	public void validate_eqCashReinvestCapGainPage() {
		result = Reports.extent.createTest("Equity Cash Re-Invest Cap Gain", "Validate Equity Cash Re-Invest Cap Gain page");
		cashReinvestCapGainTab().click();
		cf.sleepWait(1500);

		//Select date.
		Select date = new Select(getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlhistory']")));
		String dateVal = "2020/09/29";
		date.selectByValue(dateVal);
		result.log(Status.PASS, "Selected Date as: "+dateVal);
		cf.sleepWait(1500);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		result.log(Status.PASS, "Successfully generated the Report");
		
		//Export report data.
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			exportToPDF();
			result.log(Status.PASS, "Successfully extracted the Report");
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
	}

}
