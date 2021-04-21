package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class ProcessStatus extends Base {
	
	public WebElement processStatusReportTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Process Status')]"));
	}
	
	public WebElement excelExportBtn() {
		return getDriver().findElement(By.xpath("//input[@value='Export to Excel']"));
	}

}
