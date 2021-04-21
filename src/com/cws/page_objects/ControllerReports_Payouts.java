package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class ControllerReports_Payouts extends Base
{
	public static WebElement expandControllersReports() {
		return getDriver().findElement(By.xpath("//img[@alt=\"Expand Controller's Reports\"]"));
	}
	
	public static WebElement payouts() {
		return getDriver().findElement(By.xpath("//a[text()='Payouts']"));
	}
	
	public static WebElement year() {
		return getDriver().findElement(By.xpath("//span[@title='Select Year']//parent::td//following-sibling::td//select"));
	}
	
	public static WebElement month() {
		return getDriver().findElement(By.xpath("//span[@title='Select Month']//parent::td//following-sibling::td//select"));
	}
	
	public static WebElement status() {
		return getDriver().findElement(By.xpath("//span[text()='Status:']//parent::td//following-sibling::td//span"));
	}
	
	public static WebElement approve() {
		return getDriver().findElement(By.xpath("//input[@value='Approve']"));
	}
	
	public static WebElement removeApproval() {
		return getDriver().findElement(By.xpath("//input[@value='Remove Approval']"));
	}
	
	public static WebElement exportToExcel() {
		return getDriver().findElement(By.xpath("//input[@value='Export to Excel']"));
	}
	
	public static WebElement collapseControllersReports() {
		return getDriver().findElement(By.xpath("//img[@alt=\"Collapse Controller's Reports\"]"));
	}
}
