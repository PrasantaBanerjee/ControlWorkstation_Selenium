package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class ExcelFileLoad extends Base {
	
	public WebElement fileUtilsFolder() {
		return getDriver().findElement(By.xpath("//img[@alt='Expand File Utilities']//parent::a"));
	}
	
	public WebElement excelFileLoadTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Excel File Load')]"));
	}
	
	public WebElement merrillLynchFileBtn() {
		return getDriver().findElement(By.xpath("//input[@value='Upload Merrill Lynch ']"));
	}
	
	public WebElement bankAccrualFileBtn() {
		return getDriver().findElement(By.xpath("//input[@value='Upload Bank Accrual']"));
	}
	
	public WebElement rateFileBtn() {
		return getDriver().findElement(By.xpath("//input[@value='Upload Rate File']"));
	}	
	
	public WebElement errorMessage() {
		return getDriver().findElement(By.xpath("//span[@class='Error']"));
	}
	
	public WebElement closeBtn() {
		return getDriver().findElement(By.xpath("//img[@alt='Close']"));
	}
	
}
