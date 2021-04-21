package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class HistoryDistributionQC extends Base {
	
	public WebElement histDistQCTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Distribution QC')]"));
	}

}
