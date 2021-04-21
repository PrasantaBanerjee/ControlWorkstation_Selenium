package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class ControllerReports_FeePayoutTypes extends Base
{
	public static WebElement expandControllersReports() {
		return getDriver().findElement(By.xpath("//img[@alt=\"Expand Controller's Reports\"]"));
	}

	public static WebElement expandControllersAdministration() {
		return getDriver().findElement(By.xpath("//img[@alt=\"Expand Controller's Administration\"]"));
	}
	
	public static WebElement feePayoutTypes() {
		return getDriver().findElement(By.xpath("//a[text()='Fee / Payout Types']"));
	}
	
	//Add
	public static WebElement feeType() {
		return getDriver().findElement(By.xpath("//tr[@id='x:1622888439.23:mkr:addNewRow' or @mkr='addNewRow']//td[2]"));
	}
	
	public static WebElement feeTypeDropdown() {
		return getDriver().findElement(By.xpath("//span[text()='Fee Type cannot be empty.']//parent::div//div//div//table//tbody//tr//td[2]//img"));
	}
	
	public static WebElement feeTypeDropdownSelect() {
		return getDriver().findElement(By.xpath("//ul[@id='x:884725648.7:mkr:List:nw:1']//li[2]"));
	}
	
	public static WebElement payoutType() {
		return getDriver().findElement(By.xpath("//tr[@id='x:1622888439.23:mkr:addNewRow' or @mkr='addNewRow']//td[3]"));
	}
	
	public static WebElement payoutTypeDropdown() {
		return getDriver().findElement(By.xpath("//span[text()='Payout Type cannot be empty.']//parent::div//div//div//table//tbody//tr//td[2]//img"));
	}
	
	public static WebElement payoutTypeDropdownSelect() {
		return getDriver().findElement(By.xpath("//ul[@id='x:884725647.7:mkr:List:nw:1']//li[2]"));
	}
	
	public static WebElement activeInactive() {
		return getDriver().findElement(By.xpath("//tr[@id='x:1622888439.23:mkr:addNewRow' or @mkr='addNewRow']//td[4]"));
	}
	
	public static WebElement activeInactiveDropdown() {
		return getDriver().findElement(By.xpath("//span[text()='Active/InActive cannot be empty.']//parent::div//div//div//table//tbody//tr//td[2]//img"));
	}
	
	public static WebElement activeInactiveDropdownSelect() {
		return getDriver().findElement(By.xpath("//ul[@id='x:884725646.7:mkr:List:nw:1']//li[2]"));
	}
	
	public static WebElement information() {
		return getDriver().findElement(By.xpath("//span[@class='Information' or @class='Error']"));
	}
	
	public static WebElement closePopup() {
		return getDriver().findElement(By.xpath("//img[@alt='Close']"));
	}
	
	//Update
	
	public static WebElement updateFeeType() {
		return getDriver().findElement(By.xpath("//td[text()='1' and @class='ig9a63765d']//following-sibling::td[1]"));
	}
	
	public static WebElement updateActiveInactive() {
		return getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$UltraWebGrid1$ret$ddlActiveInactive']"));
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
