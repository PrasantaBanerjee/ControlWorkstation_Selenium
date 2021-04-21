package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class CashReInvestCapGain extends Base {
	
	public WebElement cashReinvestCapGainTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Cash Re-Invest % - Cap Gain')]"));
	}
	
	
}