package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class HistoryRateNotification extends Base {
	
	public WebElement rateNotificationTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Rate Notification')]"));
	}

}
