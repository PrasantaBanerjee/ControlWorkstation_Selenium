package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class Holiday extends Base {

	public WebElement administrationFolder() {
		return getDriver().findElement(By.xpath("//img[@alt='Expand Administration']//parent::a"));
	}
	
	public WebElement holidayTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Holiday')]"));
	}
	
	public WebElement holidayDate() {
		return getDriver().findElement(By.xpath("//tr[@mkr='addNewRow']//td[text()='Stk Mkt']//preceding-sibling::td[1]"));
	}
	
	
}
