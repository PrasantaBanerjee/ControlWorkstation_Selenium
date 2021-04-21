package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class ControllerReports_Comparison extends Base
{
	public static WebElement expandControllersReports() {
		return getDriver().findElement(By.xpath("//img[@alt=\"Expand Controller's Reports\"]"));
	}
	
	public static WebElement comparison() {
		return getDriver().findElement(By.xpath("//a[text()='Comparison']"));
	}
	
	public static WebElement reportType() {
		return getDriver().findElement(By.xpath("//span[text()='Report Type']//parent::td//following-sibling::td//select"));
	}
	
	public static WebElement from() {
		return getDriver().findElement(By.xpath("//span[text()='From']//parent::td//following-sibling::td//select"));
	}
	
	public static WebElement exportToExcel() {
		return getDriver().findElement(By.xpath("//input[@value='Export to Excel']"));
	}
	
	public static WebElement collapseControllersReports() {
		return getDriver().findElement(By.xpath("//img[@alt=\"Collapse Controller's Reports\"]"));
	}
}
