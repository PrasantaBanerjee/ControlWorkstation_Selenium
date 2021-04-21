package com.cws.tests;

import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.page_objects.HalfpennyNAVBreakageQuery;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_HalfpennyNAVBreakageQuery extends HalfpennyNAVBreakageQuery{
	
	ExtentTest result;
	
	public void validate_NAVBreakageQuery()
	{
		result = Reports.extent.createTest("NAV Breakage Query", "Validate NAV Breakage Query Page.");
        NAVBreakQuery().click();
        /*
        Show_Breakage().click();
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
        Date_Range().click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        FromSSA().click();
        
        FromSSA().sendKeys("01/09/2018");
        result.log(Status.PASS, "Selected From Date: 01/09/2018");
        Screenshot.captureScreenshot(getDriver(), "Screenshot_");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        custodian1().click();
        Select AdjustmentType1 = new Select(HalfpennyNAVBreakageQuery.custodian1());
        AdjustmentType1.selectByVisibleText("CIT");
        result.log(Status.PASS, "Selected Adjustment type: CIT");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Show_Breakage1().click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        result.log(Status.PASS, "Successfully generated the Report.");
        Export_Excel1().click();
        Screenshot.captureScreenshot(getDriver(), "Screenshot_");
        result.log(Status.PASS, "Clicked on Export button.");
		result.log(Status.PASS, "Successfully extracted the Report.");
		
	}

}
