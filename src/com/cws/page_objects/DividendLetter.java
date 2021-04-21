package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class DividendLetter extends Base {
	
	public WebElement histDividendLetterTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Dividend Letter')]"));
	}
	
	public WebElement custodianDropdown() {
		return getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlCustodian']"));
	}
	
}
