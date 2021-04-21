package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class DailyBreakage extends Base {
	
	public WebElement dailyBreakageTab() {
		return getDriver().findElement(By.xpath("(//a[contains(text(),'Daily Breakage')])[1]"));
	}
	
}
