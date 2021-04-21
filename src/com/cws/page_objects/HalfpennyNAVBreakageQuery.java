package com.cws.page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class HalfpennyNAVBreakageQuery extends Base {
	/*public static WebElement halfpenny() {
        return getDriver().findElement(By.xpath("//a[contains(@href,'Halfpenny')]//img"));
    }*/
	
	public static WebElement NAVBreakQuery() {
        return getDriver().findElement(By.xpath("//a[text()='NAV Breakages Query']"));
	}
	//single date
	
	public static WebElement Show_Breakage() {
        return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnShowBreakages']"));
        
    }
	public static WebElement Export_Excel() {
        return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnExport']"));
        
    }
	//date range
	public static WebElement Date_Range() {
        return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$chkRange']"));
        
    }
	public static WebElement FromSSA() {
        return getDriver().findElement(By.xpath("//input[@class='igte_Windows7EditInContainer']"));
        
    }
	public static WebElement custodian1() {
        return getDriver().findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlCustodian']"));
        
    }
	public static WebElement Show_Breakage1() {
        return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnShowBreakages']"));
        
    }
	public static WebElement Export_Excel1() {
        return getDriver().findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnExport']"));
        
    }
}