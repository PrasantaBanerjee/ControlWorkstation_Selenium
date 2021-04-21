package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class HalfpennyDailyNAVBreakageHistory extends Base{
	/*public static WebElement halfpenny() {
        return getDriver().findElement(By.xpath("//a[contains(@href,'Halfpenny')]//img"));
    }*/
	
	//Daily NAV Breakage History module
		public static WebElement DailyNAV_History() {
	        return getDriver().findElement(By.xpath("//a[text()='Daily NAV Breakage History']"));     
	    }
		
		public static WebElement Print_DailyNAVHistory() {
	        return getDriver().findElement(By.xpath("//img[@id='IconImg_rptview_toptoolbar_print']"));     
	    }
		public static WebElement PrintBtn_DailyNAV_History() {
	        return getDriver().findElement(By.xpath("//a[text()='Export']"));     
	    }
		public static WebElement Export_DailyNAVHistory() {
	        return getDriver().findElement(By.xpath("//img[@id='IconImg_rptview_toptoolbar_export']"));     
	    }
		public static WebElement Select_Export_DailyNAVBreakageHistory() {
		       return getDriver().findElement(By.xpath("//img[@title='Click here to access File Format: options']"));     
		    }
			public static WebElement Click_Export_DailyNAVBreakageHistory() {
			       return getDriver().findElement(By.xpath("//span[text()='Microsoft Excel (97-2003)']"));     
			    }
		public static WebElement Exportbtn_DailyNAVHistory() {
	        return getDriver().findElement(By.xpath("//a[text()='Export']"));     
	    }
		
}
