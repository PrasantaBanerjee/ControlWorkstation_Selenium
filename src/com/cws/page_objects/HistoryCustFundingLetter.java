package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class HistoryCustFundingLetter extends Base {
	
	public WebElement histCustFundLetterTab() {
		return getDriver().findElement(By.xpath("(//a[contains(text(),'Custody Funding Letter')])[2]"));
	}
	
	public WebElement custodianDropdown() {
		return getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlCustodian']"));
	}
	
	
}
