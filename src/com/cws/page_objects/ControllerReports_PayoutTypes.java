package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class ControllerReports_PayoutTypes extends Base
{
	public static WebElement expandControllersReports() {
		return getDriver().findElement(By.xpath("//img[@alt=\"Expand Controller's Reports\"]"));
	}

	public static WebElement expandControllersAdministration() {
		return getDriver().findElement(By.xpath("//img[@alt=\"Expand Controller's Administration\"]"));
	}
	
	public static WebElement payoutTypes() {
		return getDriver().findElement(By.xpath("//a[text()='Payout Types']"));
	}
	
	//Add
	public static WebElement selectPayoutTypeId() {
		return getDriver().findElement(By.xpath("//td[text()='--Please Select--']//preceding-sibling::td[2]"));
	}
	
	public static WebElement enterPayoutTypeId() {
		return getDriver().findElement(By.xpath("//span[text()='Column value is required.']//following-sibling::input[2]"));
	}
	
	public static WebElement selectPayoutTypeTextbox() {
		return getDriver().findElement(By.xpath("//td[text()='--Please Select--']//preceding-sibling::td[1]"));
	}
	
	public static WebElement enterPayoutTypeTextbox() {
		return getDriver().findElement(By.xpath("//span[text()='Column value is required.']//following-sibling::input[2]"));
	}
	
	public static WebElement activeInactiveDropdown() {
		return getDriver().findElement(By.xpath("//td[text()='--Please Select--']"));
	}
	
	public static WebElement activeInactiveDropdownImage() {
		return getDriver().findElement(By.xpath("//input[@value='--Please Select--']//parent::td//following-sibling::td//img"));
	}
	
	public static WebElement activeInactiveDropdownValue() {
		return getDriver().findElement(By.xpath("//li[@class='igdd_Windows7ListItem '][2]"));
	}
	
	public static WebElement information() {
		return getDriver().findElement(By.xpath("//span[@class='Information' or @class='Error']"));
	}
	
	public static WebElement closePopup() {
		return getDriver().findElement(By.xpath("//img[@alt='Close']"));
	}
	
	//Update
	public static WebElement updatePayoutTypeId() {
		return getDriver().findElement(By.xpath("//td[text()='D']"));
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
