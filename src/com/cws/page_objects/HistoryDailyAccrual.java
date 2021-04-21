package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class HistoryDailyAccrual extends Base {
	
	public WebElement historyFolder() {
		return getDriver().findElement(By.xpath("//img[@alt='Expand History']//parent::a"));
	}
	
	public WebElement dailyHistoryFolder() {
		return getDriver().findElement(By.xpath("//img[@alt='Expand Daily History']//parent::a"));
	}
	
	public WebElement dailyAccrualTab() {
		return getDriver().findElement(By.xpath("(//a[contains(text(),'Daily Accrual')])[2]"));
	}
	
	public WebElement portfolioDropdown() {
		return getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlPortfolio']"));
	}
	
	public WebElement showAdjustmentsBtn() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnAdjustment']"));
	}
	
	public WebElement showAdjustmentsFrame() {
		return getDriver().findElement(By.xpath("//iframe[starts-with(@title,'AdjustmentView.aspx')]"));
	}
	
	public WebElement showAdjustmentsExportBtn() {
		return getDriver().findElement(By.xpath("//input[@value='Export to Excel' and @id='btnExport']"));
	}
	
	public WebElement exportBtn() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnExport']"));
	}
	
	public WebElement cancelBtn() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnCancel']"));
	}	
	
	public WebElement closeBtn() {
		return getDriver().findElement(By.xpath("//img[@mkr='Close']"));
	}

}
