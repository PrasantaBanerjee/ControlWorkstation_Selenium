package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class DailyAccrual extends Base {
	
	public WebElement dailyAccrualProcessFolder() {
		return getDriver().findElement(By.xpath("//img[@alt='Expand Daily Accrual Process']//parent::a"));
	}
	
	public WebElement dailyAccrualTab() {
		return getDriver().findElement(By.xpath("//a[@id='ctl00_TreeView1t17']"));
	}
	
	public WebElement portfolioDropdown() {
		return getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlPortfolio']"));
	}
	
	public WebElement bankAccrualTableTab() {
		return getDriver().findElement(By.xpath("//tr[@id='x:1622888439.18:adr:0:tag:']//td[2]"));
	}
	
	public WebElement accrualAdjustmentTab() {
		return getDriver().findElement(By.xpath("//tr[@id='x:1622888439.18:adr:0:tag:']//td[8]"));
	}
	
	public WebElement amountTextbox() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$UltraWebGrid1$ret$ucNEWR$txtRate']"));
	}
	
	public WebElement reasonsDropdown() {
		return getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$UltraWebGrid1$ret$ucNEWR$ddlReason']"));
	}
	
	public WebElement okBtn() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$UltraWebGrid1$ret$btnOk']"));
	}
	
	public WebElement submitBtn() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnUpdate']"));
	}
	
	public WebElement recalculateBtn() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnRecalculate']"));
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
