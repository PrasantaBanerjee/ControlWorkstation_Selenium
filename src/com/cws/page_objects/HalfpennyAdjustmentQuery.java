package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class HalfpennyAdjustmentQuery extends Base {
	/*public static WebElement halfpenny() {
        return getDriver().findElement(By.xpath("//a[contains(@href,'Halfpenny')]//img"));
    }*/
	
	public static WebElement Halfpenny_AdjQuery() {
        return getDriver().findElement(By.xpath("//a[text()='Halfpenny Adjustments Query']"));
      
    }
	//single date
	public static WebElement Adj_Type() {
        return getDriver().findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_ddlAdjType']"));
        
    }
	public static WebElement Show_Adj() {
        return getDriver().findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnShowAdjustments']"));
        
    }
	public static WebElement Export_Excel() {
        return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnExport']"));
        
    }
	//Date range
	public static WebElement Date_Range() {
        return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$chkRange']"));
        
    }
	public static WebElement FromSSA() {
        return getDriver().findElement(By.xpath("//input[@class='igte_Windows7EditInContainer']"));
        
    }
	public static WebElement Show_Adj1() {
        return getDriver().findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnShowAdjustments']"));
        
    }
	public static WebElement Export_Excel1() {
        return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnExport']"));
        
    }
}
