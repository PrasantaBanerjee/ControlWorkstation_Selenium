package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class GenerateDailyEvents extends Base {
	
	public WebElement generateDailyEventsTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Generate Daily Events')]"));
	}
	
	public WebElement yearDropdown() {
		return getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlYear']"));
	}
	
	public WebElement generateBtn() {
		return getDriver().findElement(By.xpath("//input[@type='submit']"));
	}
	
	public WebElement closeBtn() {
		return getDriver().findElement(By.xpath("//img[@alt='Close']"));
	}
	
}
