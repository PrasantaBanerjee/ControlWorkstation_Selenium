package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class ControllerReports_BPS extends Base
{
	public static WebElement expandControllersReports() {
		return getDriver().findElement(By.xpath("//img[@alt=\"Expand Controller's Reports\"]"));
	}

	public static WebElement expandControllersAdministration() {
		return getDriver().findElement(By.xpath("//img[@alt=\"Expand Controller's Administration\"]"));
	}
	
	public static WebElement bps() {
		return getDriver().findElement(By.xpath("//a[text()='BPS']"));
	}
	
	//Add
	public static WebElement fundName() {
		return getDriver().findElement(By.xpath("//tr[@id='x:1622888439.23:mkr:addNewRow' or @mkr='addNewRow']//td[2]"));
	}
	
	public static WebElement fundNameDropdown() {
		return getDriver().findElement(By.xpath("//span[text()='Fund Name - Fund Class cannot be empty.']//parent::div//div//div//table//tbody//tr//td[2]//img"));
	}
	
	public static WebElement fundNameDropdownSelect() {
		return getDriver().findElement(By.xpath("//ul[@id='x:884725648.7:mkr:List:nw:1']//li[2]"));
	}

	public static WebElement feePayoutRelationship() {
		return getDriver().findElement(By.xpath("//tr[@id='x:1622888439.23:mkr:addNewRow' or @mkr='addNewRow']//td[4]"));
	}
	
	public static WebElement feePayoutRelationshipDropdown() {
		return getDriver().findElement(By.xpath("//span[text()='Fee / Payout Type Relationship cannot be empty.']//parent::div//div//div//table//tbody//tr//td[2]//img"));
	}
	
	public static WebElement feePayoutRelationshipDropdownSelect() {
		return getDriver().findElement(By.xpath("//ul[@id='x:884725647.7:mkr:List:nw:1']//li[2]"));
	}
	
	public static WebElement bpsTextbox() {
		return getDriver().findElement(By.xpath("//tr[@id='x:1622888439.23:mkr:addNewRow' or @mkr='addNewRow']//td[5]"));
	}
	
	public static WebElement bpsTextboxInput() {
		return getDriver().findElement(By.xpath("//input[@name='ctl00_ContentPlaceHolder1_UltraWebGrid1_ctl02']"));
	}
	
	public static WebElement information() {
		return getDriver().findElement(By.xpath("//span[@class='Information' or @class='Error']"));
	}
	
	public static WebElement closePopup() {
		return getDriver().findElement(By.xpath("//img[@alt='Close']"));
	}
	
	//Update
	
	public static WebElement updateFundName() {
		return getDriver().findElement(By.xpath("//td[text()='1' and @class='ig9a63765d']//following-sibling::td[1]"));
	}
	
	public static WebElement updateBps() {
		return getDriver().findElement(By.xpath("//input[@columnkey='BPS']"));
	}
	
	public static WebElement submitButton() {
		return getDriver().findElement(By.xpath("//input[@value='Submit']"));
	}
	
	public static WebElement updateClosePopup() {
		return getDriver().findElement(By.xpath("//span[@class='igdw_Windows7HeaderCaption']//parent::td//following-sibling::td[1]//img"));
	}
	
	//Export to Excel
	public static WebElement exportToExcel() {
		return getDriver().findElement(By.xpath("//input[@value='Export to Excel']"));
	}
	
	public static WebElement collapseControllersAdministration() {
		return getDriver().findElement(By.xpath("//img[@alt=\"Collapse Controller's Administration\"]"));
	}
	public static WebElement collapseControllersReports() {
		return getDriver().findElement(By.xpath("//img[@alt=\"Collapse Controller's Reports\"]"));
	}
}
