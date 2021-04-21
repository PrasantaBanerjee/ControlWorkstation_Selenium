package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class FileStatus extends Base {
	
	public WebElement fileStatusReportTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'File Status')]"));
	}
	
	public WebElement excelExportBtn() {
		return getDriver().findElement(By.xpath("//input[@value='Export to Excel']"));
	}
}
