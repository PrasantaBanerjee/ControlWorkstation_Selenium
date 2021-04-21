package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class HistoryCustFundingLetterQC extends Base {
	
	public WebElement histCustFundLetterQCTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Custody Funding Letter QC')]"));
	}
	

}
