package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class FundClass extends Base {
	
	public WebElement fundClassTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Fund Class')]"));
	}
	
	public WebElement fundClassTextbox() {
		return getDriver().findElement(By.xpath("//tr[@mkr='addNewRow']//td"));
	}
	

}
