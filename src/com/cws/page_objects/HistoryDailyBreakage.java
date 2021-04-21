package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class HistoryDailyBreakage extends Base {
	
	public WebElement histDailyBreakageTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Daily Breakage')]"));
	}

}
