package com.cws.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.FileStatus;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_FileStatus extends FileStatus {
	
	CommonFunctions cf = new CommonFunctions();
	ExtentTest fileStatus; 
	
	public void openFileStatusReportTab() {
		fileStatusReportTab().click();
	}

	public void selectDateAs(String date) {
		cf.sleepWait(1500);
		Select dates = new Select(getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlhistory']")));
		dates.selectByValue(date);
		fileStatus.log(Status.PASS, "Selected Date: "+date);
	}

	public void exportToExcel() {
		cf.sleepWait(3000);
		excelExportBtn().click();	
		fileStatus.log(Status.PASS, "Successfully extracted the Report.");
		cf.sleepWait(1500);
	}

	public void validate_fileStatusReportPage() {
		fileStatus = Reports.extent.createTest("File Status Report", "Validate File Status Report.");
		openFileStatusReportTab();
		selectDateAs("2020/10/21");
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		fileStatus.log(Status.PASS, "Successfully generated the Report.");
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			exportToExcel();
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
	}

}
