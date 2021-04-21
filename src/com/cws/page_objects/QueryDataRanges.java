package com.cws.page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class QueryDataRanges extends Base {

	public WebElement queryDateRangeFolder() {
		return getDriver().findElement(By.xpath("//img[@alt='Expand Fund Audits']/parent::a"));
	}

	public WebElement queryDateRangeTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Query Data Ranges')]"));
	}

	public WebElement date() {
		return getDriver().findElement(By.xpath("//input[@id='x:1383158390.0:mkr:3']"));
	}
	
	public WebElement dateRangeBtn() {
		return getDriver().findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_chkDateRange']"));
	}

	public WebElement allTrustBtn() {
		return getDriver().findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_rbTrust']"));
	}
	
	/*
	 * Following objects are w.r.t. Outstanding Shares Report inside Query Date Ranges.
	 */
	public WebElement outstandingSharesBtn() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnOutstandingShares']"));
	}

	public WebElement outstandingSharesFrame() {
		return getDriver().findElement(By.xpath("//iframe[@title='Fund_Audit_Outstanding_Shares.aspx']"));
	}

	public List<WebElement> outstandingShares_columns() {
		return getDriver().findElements(By.xpath("//tr[@id='x:993003626.17:mkr:columnHeaderRow']//th"));
	}

	public List<WebElement> outstandingShares_rows() {
		return getDriver().findElements(By.xpath("//tbody[@id='x:993003626.19:mkr:rows']//tr/td[1]"));
	}

	/*
	 * Following objects are w.r.t. Dividend Information Report inside Query Date Ranges.
	 */
	public WebElement dividendInformationBtn() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnDividend']"));
	}

	public WebElement dividendInformationFrame() {
		return getDriver().findElement(By.xpath("//iframe[@title='Fund_Audit_Dividend_Info.aspx']"));
	}
	
	public List<WebElement> dividendInformation_columns() {
		return getDriver().findElements(By.xpath("//tr[@id='x:993003626.19:mkr:columnHeaderRow']//th"));
	}

	public List<WebElement> dividendInformation_rows() {
		return getDriver().findElements(By.xpath("//tbody[@id='x:993003626.21:mkr:rows']//tr/td[1]"));
	}

	/*
	 * Following objects are w.r.t. Share & Dollar Activity Report inside Query Date Ranges.
	 */
	public WebElement shareAndDollarActivityBtn() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnShareDollarActivity']"));
	}

	public WebElement shareAndDollarActivityFrame() {
		return getDriver().findElement(By.xpath("//iframe[@title='Fund_Audit_Share_Dollar_Activity.aspx']"));
	}
	
	public List<WebElement> shareAndDollarActivity_columns() {
		return getDriver().findElements(By.xpath("//tr[@id='x:993003626.17:mkr:columnHeaderRow']//th"));
	}

	public List<WebElement> shareAndDollarActivity_rows() {
		return getDriver().findElements(By.xpath("//tbody[@id='x:993003626.19:mkr:rows']//tr/td[1]"));
	}

	/*
	 * Following objects are w.r.t. Dev Fund Activity Report inside Query Date Ranges.
	 */
	public WebElement devFundActivityBtn() {
		return getDriver()
				.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnShareDollarActivityDev']"));
	}

	public WebElement devFundActivityFrame() {
		return getDriver().findElement(By.xpath("//iframe[@title='Fund_Audit_Share_Dollar_Activity_Dev.aspx']"));
	}
	
	public List<WebElement> devFundActivity_columns() {
		return getDriver().findElements(By.xpath("//tr[@id='x:993003626.17:mkr:columnHeaderRow']//th"));
	}

	public List<WebElement> devFundActivity_rows() {
		return getDriver().findElements(By.xpath("//tbody[@id='x:993003626.19:mkr:rows']//tr/td[1]"));
	}

	/*
	 * Following objects are w.r.t. Payable & Receivable Report inside Query Date Ranges.
	 */
	public WebElement payableAndReceivableBtn() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnPayable']"));
	}

	public WebElement payableAndReceivableFrame() {
		return getDriver().findElement(By.xpath("//iframe[@title='Fund_Audit_Payable_Receivables.aspx']"));
	}
	
	public List<WebElement> payableAndReceivable_columns() {
		return getDriver().findElements(By.xpath("//tr[@id='x:1183991540.17:mkr:columnHeaderRow']//th"));
	}

	public List<WebElement> payableAndReceivable_rows() {
		return getDriver().findElements(By.xpath("//tbody[@id='x:1183991540.19:mkr:rows']//tr/td[1]"));
	}

	/*
	 * Following objects are w.r.t. Activity After FYE Report inside Query Date Ranges.
	 */
	public WebElement activityAfterFYEBtn() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnActivityAfterFYE']"));
	}

	public WebElement activityAfterFYEFrame() {
		return getDriver().findElement(By.xpath("//iframe[@title='Fund_Audit_Activity_After_FYE.aspx']"));
	}
	
	public List<WebElement> activityAfterFYE_columns() {
		return getDriver().findElements(By.xpath("//tr[@id='x:993003626.17:mkr:columnHeaderRow']//th"));
	}

	public List<WebElement> activityAfterFYE_rows() {
		return getDriver().findElements(By.xpath("//tbody[@id='x:993003626.19:mkr:rows']//tr/td[1]"));
	}

	/*
	 * Following objects are w.r.t. Capstock Cash Report inside Query Date Ranges.
	 */
	public WebElement capstockCashBtn() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnCapstockCash']"));
	}

	public WebElement capstockCashFrame() {
		return getDriver().findElement(By.xpath("//iframe[@title='Fund_Audit_Capstock_Cash.aspx']"));
	}
	
	public List<WebElement> capstockCash_columns() {
		return getDriver().findElements(By.xpath("//tr[@id='x:993003626.15:mkr:columnHeaderRow']//th"));
	}

	public List<WebElement> capstockCash_rows() {
		return getDriver().findElements(By.xpath("//tbody[@id='x:993003626.17:mkr:rows']//tr/td[1]"));
	}

	/*
	 * Following objects are w.r.t. Daily Share & Dollar Activity Report inside Query Date Ranges.
	 */
	public WebElement dailyShareAndDollarActivityBtn() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnDailyShareDollarActivity']"));
	}

	public WebElement dailyShareAndDollarActivityFrame() {
		return getDriver().findElement(By.xpath("//iframe[@title='Fund_Audit_Daily.aspx']"));
	}
	
	public List<WebElement> dailyShareAndDollarActivity_columns() {
		return getDriver().findElements(By.xpath("//tr[@id='x:993003626.17:mkr:columnHeaderRow']//th"));
	}

	public List<WebElement> dailyShareAndDollarActivity_rows() {
		return getDriver().findElements(By.xpath("//tbody[@id='x:993003626.19:mkr:rows']//tr/td[1]"));
	}

}
