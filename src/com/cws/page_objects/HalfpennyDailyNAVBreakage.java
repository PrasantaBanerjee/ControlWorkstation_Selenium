
package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class HalfpennyDailyNAVBreakage extends Base
{    
    public static WebElement halfpenny() {
        return getDriver().findElement(By.xpath("//a[contains(@href,'Halfpenny')]//img"));
    }
//Daily NAV Breakage module
	public static WebElement DailyNAV_Breakage() {
        return getDriver().findElement(By.xpath("//a[text()='Daily NAV Breakage']"));     
    }
	public static WebElement Print_DailyNAVBreakage() {
        return getDriver().findElement(By.xpath("//img[@id='IconImg_rptview_toptoolbar_print']"));     
    }
	public static WebElement Printbtn_DailyNAVBreakage() {
        return getDriver().findElement(By.xpath("//a[text()='Export']"));     
    }
	public static WebElement Export_DailyNAVBreakage() {
        return getDriver().findElement(By.xpath("//img[@id='IconImg_rptview_toptoolbar_export']"));     
    }
	public static WebElement Select_Export_DailyNAVBreakage() {
       return getDriver().findElement(By.xpath("//img[@title='Click here to access File Format: options']"));     
    }
	public static WebElement Click_Export_DailyNAVBreakage() {
	       return getDriver().findElement(By.xpath("//span[text()='Microsoft Excel (97-2003)']"));     
	    }
	
	public static WebElement Exportbtn_DailyNAVBreakage() {
        return getDriver().findElement(By.xpath("//a[text()='Export']"));     
    }
	
	
}