package com.cws.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.ExcelFileLoad;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_ExcelFileLoad extends ExcelFileLoad {

	CommonFunctions cf = new CommonFunctions();
	ExtentTest fileload;
	
	public void openExcelFileLoadPage() {
		fileUtilsFolder().click();
		cf.sleepWait(1500);
		excelFileLoadTab().click();
		cf.sleepWait(1000);
	}

	/*
	 * Negative test scenarios where we click on upload button without providing valid file.
	 */
	public void uploadMerrillLynch() {
		merrillLynchFileBtn().click();
		fileload.log(Status.PASS, "Clicked on \"Upload Merrill Lynch\" button");
		System.out.println("Failed to upload file: " + errorMessage().getText());
		fileload.log(Status.FAIL, "Failed to upload file: " + errorMessage().getText());
		cf.sleepWait(500);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		closeBtn().click();
	}
	
	public void uploadBankAccrual() {		
		bankAccrualFileBtn().click();
		fileload.log(Status.PASS, "Clicked on \"Upload Bank Accrual\" button");
		System.out.println("Failed to upload file: " + errorMessage().getText());
		fileload.log(Status.FAIL, "Failed to upload file: " + errorMessage().getText());
		cf.sleepWait(500);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		closeBtn().click();
	}
	
	public void uploadRate() {		
		rateFileBtn().click();
		fileload.log(Status.PASS, "Clicked on \"Upload Rate File\" button");
		System.out.println("Failed to upload file: " + errorMessage().getText());
		fileload.log(Status.FAIL, "Failed to upload file: " + errorMessage().getText());
		cf.sleepWait(500);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		closeBtn().click();
	}

	public void validate_excelFileLoad() {
		fileload = Reports.extent.createTest("Excel File Load", "Validate Excel File Load options for Merrill Lynch, Bank Accrual & Rate file.");
		openExcelFileLoadPage();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		uploadMerrillLynch();
		uploadBankAccrual();
		uploadRate();
		System.out.println("=============================================================================");
	}
}
