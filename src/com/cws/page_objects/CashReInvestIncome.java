package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class CashReInvestIncome extends Base {
	
	public WebElement equityHistoryTab() {
		return getDriver().findElement(By.xpath("//img[@alt='Expand Equity History']//parent::a"));
	}
	
	public WebElement cashReinvestIncomeTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Cash Re-Invest % - Income')]"));
	}
	
}