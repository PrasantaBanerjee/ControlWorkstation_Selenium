package com.cws.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.DividendLetter;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_HistoryDividendLetter extends DividendLetter {
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
	
	public void navigateToReportLastPage() {
		getDriver().findElement(By.xpath("//img[@alt='Click here to access Page Navigation options']")).click();
		getDriver().findElement(By.xpath("//span[@title='Go to Last Page']")).click();
	}
	
	public void signatureIsDisplayed() {
		getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[starts-with(@id,'bobj')]")));
		cf.sleepWait(1000);
		
		try {
			if(getDriver().findElement(By.xpath("//img[@alt='Image']")).isDisplayed()) {
				System.out.println("Signature is available");
				result.log(Status.PASS, "Signature is available");
				JavascriptExecutor jse = (JavascriptExecutor)getDriver();
				jse.executeScript("arguments[0].scrollIntoView();",getDriver().findElement(By.xpath("//img[@alt='Image']")));
			}
		} catch(NoSuchElementException e) {
			System.out.println("Signature not available.");
			result.log(Status.FAIL, "Signature is not available");
		}
		
		getDriver().switchTo().defaultContent();
	}

	public void validate_histDividendLetterPage() {
		result = Reports.extent.createTest("History Dividend Letter", "Validate History Dividend Letter page");
		histDividendLetterTab().click();
		cf.sleepWait(1000);

		// Select date.
		Select date = new Select(getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlhistory']")));
		String dateValue = "2020/09/30";
		date.selectByValue(dateValue);
		result.log(Status.PASS, "Selected Date: "+dateValue);
		cf.sleepWait(1000);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		// Select custodian.
		Select custodian = new Select(custodianDropdown());
		String custVal = "CIT";
		custodian.selectByValue(custVal);
		result.log(Status.PASS, "Selected Custodian: "+custVal);
		cf.sleepWait(1500);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		
		//Navigate to Last page & validate if Signature is present or not.
		navigateToReportLastPage();
		result.log(Status.PASS, "Navigated to Last page of Report");
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		cf.sleepWait(1000);
		signatureIsDisplayed();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		// Export report data.
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			exportToPDF();
			result.log(Status.PASS, "Clicked on Export button");
			result.log(Status.PASS, "Successfully extracted the Report");
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

	}
}