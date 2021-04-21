package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class HistoryDivT extends Base {
	
	public WebElement histDivTTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Div-T')]"));
	}
	
	public WebElement DDADropdown() {
		return getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlDDA']"));
	}
		
}