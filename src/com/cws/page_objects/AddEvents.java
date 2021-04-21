package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class AddEvents extends Base {
	
	public WebElement dividendsFolder() {
		return getDriver().findElement(By.xpath("//img[@alt='Expand Dividends']//parent::a"));
	}
	
	public WebElement dividendsAdministrationFolder() {
		return getDriver().findElement(By.xpath("//img[@alt='Expand Dividends Administration']//parent::a"));
	}
	
	public WebElement addEventsTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Add Events')]"));
	}
	
	public WebElement portfolioDropdown() {
		return getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlPortfolio']"));
	}
	
	public WebElement fundDropdown() {
		return getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$lbxFund']"));
	}
	
	public WebElement processTypeDropdown() {
		return getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlProcessType']"));
	}
	
	public WebElement incomeDividendCheckbox() {
		return getDriver().findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_chkIncomeDiv']"));
	}
	
	public WebElement incomeRate() {
		return getDriver().findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_wneIncomeRate']"));
	}
	
	public WebElement submitBtn() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnSubmit']"));
	}
	
	public WebElement errorMessage() {
		return getDriver().findElement(By.xpath("//span[@class='Error']"));
	}
	
	public WebElement closeBtn() {
		return getDriver().findElement(By.xpath("//img[@alt='Close']"));
	}
	
}
