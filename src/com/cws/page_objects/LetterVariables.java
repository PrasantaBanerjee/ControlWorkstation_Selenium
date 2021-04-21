package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class LetterVariables extends Base {
	
	public WebElement letterVariablesTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Letter Variables')]"));
	}
	
	public WebElement dailyCFLTo() {
		return getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlDailyCFLTo']"));
	}
	
	public WebElement equityCFLFrom() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtEquityCFLFrom']"));
	}
	
	public WebElement equityDivCtrlMgr() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtEquityDivControlManager']"));
	}
	
	public WebElement submitBtn() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnSubmit']"));
	}
	
	public WebElement closeBtn() {
		return getDriver().findElement(By.xpath("//img[@alt='Close']"));
	}

}
