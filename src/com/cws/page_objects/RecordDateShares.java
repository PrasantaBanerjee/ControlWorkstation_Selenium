package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class RecordDateShares extends Base {
	
	public WebElement recordDateSharesTab() {
		return getDriver().findElement(By.xpath("(//a[contains(text(),'Record Date Shares')])[1]"));
	}
	
	public WebElement recordDateSharesComparisonTab() {
		return getDriver().findElement(By.xpath("(//a[contains(text(),'Record Date Shares')])[2]"));
	}
	
}

