package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class ModifyEvents extends Base {
	
	public WebElement modifyEventsTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Modify Events')]"));
	}
	
	public WebElement fund() {
		return getDriver().findElement(By.xpath("//td[contains(text(),'4480')]"));
	}
	
	public WebElement shortTermCapGainCheckbox() {
		return getDriver().findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_whdgModifyEvents_ctl00_ret_chkShortTermCapGain']"));
	}
	
	public WebElement okBtn() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$whdgModifyEvents$ctl00$ret$buttonOK']"));
	}
	
	public WebElement closeBtn() {
		return getDriver().findElement(By.xpath("//img[@mkr='Close']"));
	}
	
	public WebElement statusOfFund() {
		return getDriver().findElement(By.xpath("//td[contains(text(),'4480')]//parent::tr//td[11]"));
	}
	
	public WebElement exportBtn() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnExport']"));
	}
}
