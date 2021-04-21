package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class HalfpennyDetailsHistory extends Base {
	
	/*public static WebElement halfpenny() {
        return getDriver().findElement(By.xpath("//a[contains(@href,'Halfpenny')]//img"));
    }*/
	 public static WebElement Details_History() {
	        return getDriver().findElement(By.xpath("//a[text()='Details History']"));
	    }
	 
	 public static WebElement Export_To_Excel() {
	        return getDriver().findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnExport']"));
	    }
	 
	 public static WebElement Cancel_Btn() {
	        return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnCancel']"));
	    }
	 public static WebElement Custodian() {
	        return getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlCustodian']"));
	    }
	 public static WebElement Export_To_Excel1() {
	        return getDriver().findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnExport']"));
	    } 
}
