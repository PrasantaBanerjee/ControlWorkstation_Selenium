package com.cws.tests;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.DailyBreakage;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_DailyBreakage extends DailyBreakage {

	CommonFunctions cf = new CommonFunctions();
	ExtentTest dailyBreakage;
	
	public void exportToExcel() {
		cf.sleepWait(3000);
		//Click 'Export this Report' button.
		getDriver().findElement(By.xpath("//img[@alt='Export this report']")).click();
		cf.sleepWait(1500);
		//Click 'RPT' Option drop down.
		getDriver().findElement(By.xpath("//div[contains(text(),'Crystal Reports (RPT)')]")).click();
		cf.sleepWait(1500);
		//Click 'Microsoft Excel (97-2003)' Format.
		getDriver().findElement(By.xpath("//span[@title='Microsoft Excel (97-2003)']")).click();
		cf.sleepWait(1500);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		//Click 'Export' button.
		getDriver().findElement(By.xpath("//a[contains(text(),'Export')]")).click();
		cf.sleepWait(1500);
	}

	public void validate_dailyBreakagePage() {
		dailyBreakage= Reports.extent.createTest("Daily Breakage", "Validate Daily Breakage Report");
		dailyBreakageTab().click();
		cf.sleepWait(1000);
		dailyBreakage.log(Status.PASS, "Successfully generated Daily Breakage Report.");
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			exportToExcel();
			dailyBreakage.log(Status.PASS, "Successfully downloaded the extract.");
		}
	}

}
