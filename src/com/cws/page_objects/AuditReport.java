package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class AuditReport extends Base {
	
	public WebElement reportsFolder() {
		return getDriver().findElement(By.xpath("//img[@alt='Expand Reports']//parent::a"));
	}
	
	public WebElement auditReportTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'Audit Report')]"));
	}
	
	public WebElement excelExportBtn() {
		return getDriver().findElement(By.xpath("//input[@value='Export to Excel']"));
	}
	
}
