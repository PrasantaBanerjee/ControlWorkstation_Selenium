package com.cws.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.HistoryDistributionQC;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_HistoryDistributionQC extends HistoryDistributionQC {

	CommonFunctions cf = new CommonFunctions();
	ExtentTest result;

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
		//Click 'Export' button.
		getDriver().findElement(By.xpath("//a[contains(text(),'Export')]")).click();
		cf.sleepWait(1500);
	}

	public void validate_histDistQCPage() {
		result = Reports.extent.createTest("History Distribution QC", "Validate History Distribution QC page");
		histDistQCTab().click();
		cf.sleepWait(1000);

		//Select date.
		Select date = new Select(getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlhistory']")));
		String dateValue = "2020/09/30";
		date.selectByValue(dateValue);
		result.log(Status.PASS, "Selected Date: "+dateValue);
		cf.sleepWait(3000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		//Select portfolio.
		Select portfolio = new Select(getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlPortfolio']")));
		String portfolioValue = "Tax Free Bond                                                              ";
		portfolio.selectByValue(portfolioValue);
		result.log(Status.PASS, "Selected Portfolio: "+portfolio);
		cf.sleepWait(2000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		//Export report data.
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			exportToExcel();
			result.log(Status.PASS, "Clicked on Export button");
			result.log(Status.PASS, "Successfully extracted the Report");
		}
		
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
	}

}
