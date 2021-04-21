package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class MoneyMovement extends Base {
	
	public WebElement histMoneyMovementTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Money Movement')]"));
	}
		
}