package com.cws.tests;

import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.page_objects.HalfpennyAdjustmentQuery;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_HalfpennyAdjustmentQuery extends HalfpennyAdjustmentQuery{
	
	ExtentTest result;
	
	public void validate_AdjQuery() {
		result = Reports.extent.createTest("Halfpenny Adjustment Query", "Validate Halfpenny Adjustment Query Page.");
		
        Halfpenny_AdjQuery().click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Screenshot.captureScreenshot(getDriver(), "Screenshot_");
        
        /*
         Adj_Type().click();
         Select AdjustemntType = new Select(HalfpennyAdjustmentQuery.Adj_Type());
         AdjustemntType.selectByVisibleText("Halfpenny Payout");
         try {
             Thread.sleep(4000);
         } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         Show_Adj().click();
         try {
             Thread.sleep(3000);
         } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         Export_Excel().click();
         try {
             Thread.sleep(4000);
         } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         */
         Adj_Type().click();
         Select AdjustemntType1 = new Select(HalfpennyAdjustmentQuery.Adj_Type());
         AdjustemntType1.selectByVisibleText("Daily Breakage Adj");
         result.log(Status.PASS, "Selected Adjustment type: Daily Breakage Adj");
         try {
             Thread.sleep(4000);
         } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         Screenshot.captureScreenshot(getDriver(), "Screenshot_");
         /*
         Show_Adj().click();
         try {
             Thread.sleep(4000);
         } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         Export_Excel().click();
         try {
             Thread.sleep(4000);
         } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         */
         
         //Date range
         Date_Range().click();
         try {
             Thread.sleep(4000);
         } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         FromSSA().click();
         
         FromSSA().sendKeys("01/09/2018");
         result.log(Status.PASS, "Selected From-Date: 01/09/2018");
         Screenshot.captureScreenshot(getDriver(), "Screenshot_");
         try {
             Thread.sleep(4000);
         } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         Show_Adj1().click();
         result.log(Status.PASS, "Clicked on Show Adjustments button.");
         try {
             Thread.sleep(4000);
         } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         Screenshot.captureScreenshot(getDriver(), "Screenshot_");
         Export_Excel1().click();
         result.log(Status.PASS, "Clicked on Export button.");
         result.log(Status.PASS, "Successfully downloaded the extract.");
         Screenshot.captureScreenshot(getDriver(), "Screenshot_");	

}
}