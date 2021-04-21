package com.cws.tests;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.UserListReport;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_UserListReport extends UserListReport {

	CommonFunctions cf = new CommonFunctions();
	ExtentTest userList; 
	
	public void openUserListReportTab() {
		userListReportTab().click();
	}

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

	public void validate_userListReportPage() {
		userList = Reports.extent.createTest("User List Report", "Validate User List Report.");
		openUserListReportTab();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		userList.log(Status.PASS, "Successfully generated the Report.");
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			exportToPDF();
			userList.log(Status.PASS, "Successfully extracted the Report.");
		}
	}

}
