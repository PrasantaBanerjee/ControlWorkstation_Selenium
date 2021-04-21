package com.cws.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class CommonPageObjects extends Base{
	
	public WebElement exportToExcelBtn() {
		return getDriver().findElement(By.xpath("//input[@id='btnExport']"));
	}
	
	public WebElement exportToCSVBtn() {
		return getDriver().findElement(By.xpath("//input[@name='btnExportToCSV']"));
	}
		

}
