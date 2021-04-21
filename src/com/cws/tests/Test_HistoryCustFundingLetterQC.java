package com.cws.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.HistoryCustFundingLetterQC;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_HistoryCustFundingLetterQC extends HistoryCustFundingLetterQC {

	CommonFunctions cf = new CommonFunctions();
	ExtentTest result;

	public void exportToPDF() {
		cf.sleepWait(3000);
		//Click 'Export this Report' button.
		getDriver().findElement(By.xpath("//img[@alt='Export this report']")).click();
		cf.sleepWait(1500);
		//Click 'RPT' Option drop down.
		getDriver().findElement(By.xpath("//div[contains(text(),'Crystal Reports (RPT)')]")).click();
		cf.sleepWait(1500);
		//Click 'PDF' Format.
		getDriver().findElement(By.xpath("//span[@title='PDF']")).click();
		cf.sleepWait(1500);
		//Click 'Export' button.
		getDriver().findElement(By.xpath("//a[contains(text(),'Export')]")).click();
		cf.sleepWait(1500);
	}

	public void validate_historyCustFundingLetterQC() {
		result = Reports.extent.createTest("History Custody Funding Letter QC", "Validate History Custody Funding Letter QC page");
		histCustFundLetterQCTab().click();
		cf.sleepWait(3000);

		//Select date.
		Select date = new Select(getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlhistory']")));
		String dateValue = "2020/09/30";
		date.selectByValue(dateValue);
		result.log(Status.PASS, "Selected Custodian: "+dateValue);
		cf.sleepWait(1000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		//Export report data.
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			exportToPDF();
			result.log(Status.PASS, "Successfully extracted the Report");
		}
		
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

	}

}
