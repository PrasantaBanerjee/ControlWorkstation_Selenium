package com.cws.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.commons.CommonPageObjects;
import com.cws.page_objects.QueryDataRanges;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_QueryDataRanges extends QueryDataRanges {

	CommonFunctions cf = new CommonFunctions();
	CommonPageObjects cpo = new CommonPageObjects();
	ExtentTest QueryDataRanges;	
	boolean extract = false;

	public void openQueryDateRangePage() {
		queryDateRangeFolder().click();
		cf.sleepWait(1500);
		queryDateRangeTab().click();
	}

	// Date should be in 'mm/dd/yyyy' format.
	public void selectDateAs(String dateValue) {
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		jse.executeScript("document.getElementById('x:1383158390.0:mkr:3').value='" + dateValue + "';");
		date().click();
	}

	// Date should be in 'mm/dd/yyyy' format.
	public void selectDateAs(String fromDate, String toDate) {
		dateRangeBtn().click();
		cf.sleepWait(1500);
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		// Setup From Date
		jse.executeScript("document.getElementById('x:1383158390.0:mkr:3').value='" + fromDate + "';");
		date().click();
		// Setup To Date
		jse.executeScript("document.getElementById('x:1936595901.0:mkr:3').value='" + toDate + "';");
	}

	public void validateReport(List<WebElement> allColumns, List<WebElement> allRows, ExtentTest result) {
		boolean errorMsgDisplayed = false;
		try {
			if (getDriver().findElement(By.xpath("//span[contains(text(),'Error Encountered')]")).isDisplayed()) {
				errorMsgDisplayed = true;
				extract = false;
			}
		} catch (NoSuchElementException e) {
			errorMsgDisplayed = false;
			extract = true;
		}

		if (errorMsgDisplayed == true) {
			System.err.println("ERROR ENCOUNTERED");
			result.log(Status.FAIL, "Failed to generate Report: Error Encountered");
		} else {
			// fetch column names
			System.out.println("Report shows " + (allColumns.size() - 1) + " column/s.");
			result.log(Status.PASS, "Report shows " + (allColumns.size() - 1) + " column/s.");
			for(int i=0;i<allColumns.size()-1;i++) {
				System.out.println(allColumns.get(i).getText());
				result.info(allColumns.get(i).getText());
			}

			// fetch record count
			if (allRows.size() > 0) {
				System.out.println("Total Records found: " + (allRows.size() - 1));
				result.log(Status.PASS, "Total Records found: " + (allRows.size() - 1));
				for (WebElement eachRow : allRows) {
					JavascriptExecutor jse = (JavascriptExecutor) getDriver();
					jse.executeScript("arguments[0].scrollIntoView();", eachRow);
				}
			} else {
				System.out.println("No Records Found");
				result.log(Status.WARNING, "No Records Found for the specified date range."); 
			}
		}
		System.out.println("============================================================");
	}

	public void exportToExcel(ExtentTest result) {
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			if (extract == true) {
				cpo.exportToExcelBtn().click();
				cf.sleepWait(3000);
				result.log(Status.PASS, "Successfully extracted the Report.");
			}
		}
	}

	public void exportToCSV(ExtentTest result) {
		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			if (extract == true) {
				cpo.exportToCSVBtn().click();
				cf.sleepWait(3000);
				result.log(Status.PASS, "Successfully extracted the Report.");
			}
		}
	}

	public void selectAllTrust_Custodian_FundPortfolio_FundName(ExtentTest result) {
		allTrustBtn().click();
		cf.sleepWait(1000);
		// The above click triggers an AJAX call.

		Select trustDropdown;
		try {
			trustDropdown = new Select(getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$lbxTrust']")));
			trustDropdown.selectByValue("All");
			result.log(Status.PASS, "Value selected from Trust dropdown: All");
		} catch (StaleElementReferenceException e) {
			trustDropdown = new Select(getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$lbxTrust']")));
			trustDropdown.selectByValue("All");
			result.log(Status.PASS, "Value selected from Trust dropdown: All");
		}

		Select custodianDropdown = new Select(
				getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$lbxCustodian']")));
		custodianDropdown.selectByValue("All");
		result.log(Status.PASS, "Value selected from Custodian dropdown: All");

		Select fundPortfolioDropdown = new Select(
				getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$lbxPortfolio']")));
		fundPortfolioDropdown.selectByValue("All");
		result.log(Status.PASS, "Value selected from Fund Portfolio dropdown: All");

		Select fundNameDropdown = new Select(
				getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$lbxFundName']")));
		fundNameDropdown.selectByValue("All");
		result.log(Status.PASS, "Value selected from Fund Name dropdown: All");
	}

	public void selectSpecificTrust_Custodian_FundPortfolio_FundName(ExtentTest result) {
		allTrustBtn().click();
		cf.sleepWait(1000);
		// The above click triggers an AJAX call.

		Select trustDropdown;
		try {
			trustDropdown = new Select(
					getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$lbxTrust']")));
			trustDropdown.selectByValue("JHF II");
			result.log(Status.PASS, "Value selected from Trust dropdown: JHF II");
		} catch (StaleElementReferenceException e) {
			trustDropdown = new Select(
					getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$lbxTrust']")));
			trustDropdown.selectByValue("JHF II");
			result.log(Status.PASS, "Value selected from Trust dropdown: JHF II");
		}

		Select custodianDropdown = new Select(
				getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$lbxCustodian']")));
		custodianDropdown.selectByValue("SSB");
		result.log(Status.PASS, "Value selected from Custodian dropdown: SSB");

		Select fundPortfolioDropdown = new Select(
				getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$lbxPortfolio']")));
		fundPortfolioDropdown.selectByValue("Absolute Return Currency");
		result.log(Status.PASS, "Value selected from Fund Portfolio dropdown: Absolute Return Currency");

		Select fundNameDropdown = new Select(
				getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$lbxFundName']")));
		fundNameDropdown.selectByValue("3640");
		fundNameDropdown.selectByValue("3642");
		result.log(Status.PASS, "Value selected from Fund Name dropdown: 3640,3642");

	}

	public void generate_OutstandingSharesReport(String fromDate, String toDate) {
		ExtentTest outSharesReport = QueryDataRanges.createNode("Outstanding Shares Report", "Validate Outstanding Shares Report");
		outSharesReport.log(Status.PASS, "From-Date: "+fromDate);
		outSharesReport.log(Status.PASS, "To-Date: "+toDate);
		System.out.println("Outstanding Shares Report: " + "(" + fromDate + "-" + toDate + ")");
		selectDateAs(fromDate, toDate);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		outstandingSharesBtn().click();
		cf.sleepWait(3000);

		getDriver().switchTo().frame(outstandingSharesFrame());

		List<WebElement> allColumns = outstandingShares_columns();
		List<WebElement> allRows = outstandingShares_rows();
		validateReport(allColumns, allRows, outSharesReport);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		exportToExcel(outSharesReport);
		getDriver().navigate().back();
	}

	public void generate_DividendInformationReport(String fromDate, String toDate) {
		ExtentTest divInfoReport = QueryDataRanges.createNode("Dividend Information Report", "Validate Dividend Information Report");
		divInfoReport.log(Status.PASS, "From-Date: "+fromDate);
		divInfoReport.log(Status.PASS, "To-Date: "+toDate);
		System.out.println("Dividend Information Report: " + "(" + fromDate + "-" + toDate + ")");
		selectDateAs(fromDate, toDate);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		dividendInformationBtn().click();
		cf.sleepWait(3000);

		getDriver().switchTo().frame(dividendInformationFrame());
		List<WebElement> allColumns = dividendInformation_columns();
		List<WebElement> allRows = dividendInformation_rows();
		validateReport(allColumns, allRows, divInfoReport);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		exportToExcel(divInfoReport);
		getDriver().navigate().back();
	}

	public void generate_ShareAndDollarActivityReport(String fromDate, String toDate) {
		ExtentTest shareDollarActReport = QueryDataRanges.createNode("Share And Dollar Activity Report", "Validate Share And Dollar Activity Report");
		shareDollarActReport.log(Status.PASS, "From-Date: "+fromDate);
		shareDollarActReport.log(Status.PASS, "To-Date: "+toDate);
		System.out.println("Share & Dollar Activity Report: " + "(" + fromDate + "-" + toDate + ")");
		selectDateAs(fromDate, toDate);
		selectAllTrust_Custodian_FundPortfolio_FundName(shareDollarActReport);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		shareAndDollarActivityBtn().click();
		cf.sleepWait(3000);

		getDriver().switchTo().frame(shareAndDollarActivityFrame());
		List<WebElement> allColumns = shareAndDollarActivity_columns();
		List<WebElement> allRows = shareAndDollarActivity_rows();
		validateReport(allColumns, allRows, shareDollarActReport);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		exportToExcel(shareDollarActReport);
		getDriver().navigate().back();
	}

	public void generate_DevFundActivityReport(String fromDate, String toDate) {
		ExtentTest devFundActReport = QueryDataRanges.createNode("Dev Fund Activity Report", "Validate Dev Fund Activity Report");
		devFundActReport.log(Status.PASS, "From-Date: "+fromDate);
		devFundActReport.log(Status.PASS, "To-Date: "+toDate);
		System.out.println("Dev Fund Activity Report: " + "(" + fromDate + "-" + toDate + ")");
		selectDateAs(fromDate, toDate);
		selectAllTrust_Custodian_FundPortfolio_FundName(devFundActReport);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		devFundActivityBtn().click();
		cf.sleepWait(3000);

		getDriver().switchTo().frame(devFundActivityFrame());
		List<WebElement> allColumns = devFundActivity_columns();
		List<WebElement> allRows = devFundActivity_rows();
		validateReport(allColumns, allRows, devFundActReport);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		exportToExcel(devFundActReport);
		getDriver().navigate().back();
	}

	public void generate_PayableAndReceivableReport(String fromDate, String toDate) {
		ExtentTest payableReport = QueryDataRanges.createNode("Payable And Receivable Report", "Validate Payable And Receivable Report");
		payableReport.log(Status.PASS, "From-Date: "+fromDate);
		payableReport.log(Status.PASS, "To-Date: "+toDate);
		System.out.println("Payable & Receivable Report: " + "(" + fromDate + "-" + toDate + ")");
		selectDateAs(fromDate, toDate);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		payableAndReceivableBtn().click();
		cf.sleepWait(3000);

		getDriver().switchTo().frame(payableAndReceivableFrame());
		List<WebElement> allColumns = payableAndReceivable_columns();
		List<WebElement> allRows = payableAndReceivable_rows();
		validateReport(allColumns, allRows, payableReport);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		exportToExcel(payableReport);
		getDriver().navigate().back();
	}

	public void generate_ActivityAfterFYEReport(String fromDate, String toDate) {
		ExtentTest activityReport = QueryDataRanges.createNode("Activity After FYE Report", "Validate Activity After FYE Report");
		activityReport.log(Status.PASS, "From-Date: "+fromDate);
		activityReport.log(Status.PASS, "To-Date: "+toDate);
		System.out.println("Activity after FYE Report: " + "(" + fromDate + "-" + toDate + ")");
		selectDateAs(fromDate, toDate);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		activityAfterFYEBtn().click();
		cf.sleepWait(3000);

		getDriver().switchTo().frame(activityAfterFYEFrame());
		List<WebElement> allColumns = activityAfterFYE_columns();
		List<WebElement> allRows = activityAfterFYE_rows();
		validateReport(allColumns, allRows, activityReport);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		exportToExcel(activityReport);
		getDriver().navigate().back();
	}
	
	public void generate_CapstockCashReport(String fromDate, String toDate) {
		ExtentTest capstockReport = QueryDataRanges.createNode("Capstock Cash Report", "Validate Capstock Cash Report");
		capstockReport.log(Status.PASS, "From-Date: "+fromDate);
		capstockReport.log(Status.PASS, "To-Date: "+toDate);
		System.out.println("Capstock Cash Report: " + "(" + fromDate + "-" + toDate + ")");
		selectDateAs(fromDate, toDate);
		selectAllTrust_Custodian_FundPortfolio_FundName(capstockReport);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		capstockCashBtn().click();
		cf.sleepWait(3000);

		getDriver().switchTo().frame(capstockCashFrame());
		List<WebElement> allColumns = capstockCash_columns();
		List<WebElement> allRows = capstockCash_rows();
		validateReport(allColumns, allRows, capstockReport);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		exportToExcel(capstockReport);
		exportToCSV(capstockReport);
		getDriver().navigate().back();
	}

	public void generate_DailyShareAndDollarActivityReport(String fromDate, String toDate) {
		ExtentTest dailyShareReport = QueryDataRanges.createNode("Daily Share & Dollar Activity Report", "Validate Daily Share & Dollar Activity Report");
		System.out.println("Daily Share And Dollar Activity Report: " + "(" + fromDate + "-" + toDate + ")");
		dailyShareReport.log(Status.PASS, "From-Date: "+fromDate);
		dailyShareReport.log(Status.PASS, "To-Date: "+toDate);
		selectDateAs(fromDate, toDate);
		selectSpecificTrust_Custodian_FundPortfolio_FundName(dailyShareReport);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		dailyShareAndDollarActivityBtn().click();
		dailyShareReport.log(Status.PASS, "Clicked on Daily Share & Dollar Activity Report");
		cf.sleepWait(3000);

		getDriver().switchTo().frame(dailyShareAndDollarActivityFrame());
		List<WebElement> allColumns = dailyShareAndDollarActivity_columns();
		List<WebElement> allRows = dailyShareAndDollarActivity_rows();
		validateReport(allColumns, allRows, dailyShareReport);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

		exportToExcel(dailyShareReport);
		getDriver().navigate().back();
	}

	public void validate_queryDateRangePage() { 
		QueryDataRanges = Reports.extent.createTest("Query Date Ranges", "Validate all the Reports with different date ranges & trust combinations.");
		openQueryDateRangePage();

		// Generates report using From Date & To Date for All Funds.
		generate_OutstandingSharesReport("11/25/2019", "11/25/2020");

		// Generates report using From Date & To Date for All Funds.
		generate_DividendInformationReport("10/1/2020", "11/25/2020");

		// Generates report using From Date & To Date for All Trust, All Custodian, All Fund Portfolio, All Fund Name.
		generate_ShareAndDollarActivityReport("11/25/2019", "11/25/2020");

		// Generates report using From Date & To Date for All Trust, All Custodian, All Fund Portfolio, All Fund Name.
		generate_DevFundActivityReport("11/25/2019", "11/25/2020");

		// Generates report using From Date & To Date for All Funds.
		generate_PayableAndReceivableReport("11/27/2019", "12/2/2020");

		// Generates report using From Date & To Date for All Funds.
		generate_ActivityAfterFYEReport("11/25/2019", "12/2/2020");

		// Generates report using From Date & To Date for All Trust, All Custodian, All Fund Portfolio, All Fund Name.
		generate_CapstockCashReport("1/2/2015", "12/2/2020");

		// Generates report using From Date & To Date for Specific Trust, Custodian, Fund Portfolio, Fund Name.
		//generate_DailyShareAndDollarActivityReport("11/7/2017", "12/2/2020");

	}
}