package com.cws.tests;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.AddEvents;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_AddEvents extends AddEvents {
	CommonFunctions cf = new CommonFunctions();
	ExtentTest addEvents;

	public void openAddEventsPage() {
		dividendsFolder().click();
		cf.sleepWait(1500);
		dividendsAdministrationFolder().click();
		cf.sleepWait(1500);
		addEventsTab().click();
		cf.sleepWait(1000);
	}

	public void selectPortfolioAs(String value, ExtentTest result) {
		Select portfolio = new Select(portfolioDropdown());
		portfolio.selectByValue(value);
		cf.sleepWait(1500);
		result.log(Status.PASS, "Selected Portfolio as: "+value);
	}

	public void selectFundAs(String value, ExtentTest result) {
		Select funds = new Select(fundDropdown());
		funds.selectByValue(value);
		cf.sleepWait(1500);
		result.log(Status.PASS, "Selected Fund as: "+value);
	}

	public void selectProcessTypeAs(String value, ExtentTest result) {
		Select processType = new Select(processTypeDropdown());
		processType.selectByValue(value);
		cf.sleepWait(1500);
		result.log(Status.PASS, "Selected Process Type Values as: "+value);
	}

	public void validate_addEventsPage() {
		addEvents = Reports.extent.createTest("Add Events", "Validate Add Events page");
		openAddEventsPage();
		selectPortfolioAs("Balanced", addEvents);
		selectFundAs("536", addEvents);
		selectFundAs("3378", addEvents);
		selectProcessTypeAs("Equity", addEvents);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		try {
			incomeDividendCheckbox().click();		
		} catch(StaleElementReferenceException  e) {
			incomeDividendCheckbox().click();
		}
		cf.sleepWait(500);
		incomeRate().sendKeys("15");
		addEvents.log(Status.PASS, "Entered Rate value: 15");
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		submitBtn().click();
		cf.sleepWait(500);
		addEvents.log(Status.PASS, "Clicked on Submit button");
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		System.out.println("Error message displayed as: " + errorMessage().getText());
		addEvents.log(Status.FAIL, "Error message displayed as: " + errorMessage().getText());
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		closeBtn().click();
		addEvents.log(Status.PASS, "Clicked on Close button");
		System.out.println("=======================================================================================");
		
	}

}
