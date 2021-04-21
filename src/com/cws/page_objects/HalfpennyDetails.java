package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class HalfpennyDetails extends Base{

	public static WebElement halfpenny() {
		return getDriver().findElement(By.xpath("//a[contains(@href,'Halfpenny')]//img"));
	}

	//Details module
	public static WebElement Details_Btn () {
		return getDriver().findElement(By.xpath("//a[text()='Details']"));     
	}
	public static WebElement Export_Btn () {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnExport']"));     
	}
	public static WebElement Submit_Btn () {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnUpdate']"));     
	}
	public static WebElement Submit_BtnPopup () {
		return getDriver().findElement(By.xpath("//img[@mkr='Close']"));     
	}
	public static WebElement Recalculate_Btn () {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnRecalculate']"));     
	}
	public static WebElement Recalculate_BtnPopup () {
		return getDriver().findElement(By.xpath("//img[@id='x:357742670.4:mkr:Close']"));     
	}
	public static WebElement Cancel_Btn () {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnCancel']"));     
	}
	public static WebElement Custodian() {
		return getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlCustodian']"));     
	}	
	public static WebElement Export_Btn1 () {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnExport']"));     
	}
	public static WebElement Submit_Btn1 () {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnUpdate']"));     
	}
	public static WebElement Submit_BtnPopup1 () {
		return getDriver().findElement(By.xpath("//img[@mkr='Close']"));     
	}
	public static WebElement Recalculate_Btn1 () {
		return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnRecalculate']"));     
	}
	public static WebElement Recalculate_BtnPopup1 () {
		return getDriver().findElement(By.xpath("//img[@id='x:357742670.4:mkr:Close']"));     
	}
}



