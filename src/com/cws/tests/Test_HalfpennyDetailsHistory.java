package com.cws.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.page_objects.HalfpennyDetailsHistory;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_HalfpennyDetailsHistory extends HalfpennyDetailsHistory{
	
	ExtentTest result;
	
	    public void  validate_DetailsHistory()
	    {
	    	result = Reports.extent.createTest("Details History", "Validate Details History Page.");
	    	
	        //Details History module
	        Details_History().click();
	        try {
	            Thread.sleep(4000);
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        result.log(Status.PASS, "Clicked on Details History tab.");
	        result.log(Status.PASS, "Successfully generated the Report.");
	        Screenshot.captureScreenshot(getDriver(), "Screenshot_");
	        Export_To_Excel().click();
	        try {
	            Thread.sleep(4000);
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        result.log(Status.PASS, "Clicked on Export button.");
			result.log(Status.PASS, "Successfully extracted the Report.");
			
	        Screenshot.captureScreenshot(getDriver(), "Screenshot_");
	        Cancel_Btn().click();
	        try {
	            Thread.sleep(4000);
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        Screenshot.captureScreenshot(getDriver(), "Screenshot_");
	        /*
	        Custodian().click();
	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        Select Custodianname=new  Select(HalfpennyDetailsHistory.Custodian());
	        
	         Custodianname.selectByVisibleText("BNY");
	         try {
		            Thread.sleep(4000);
		        } catch (InterruptedException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
	         Export_To_Excel1().click();  
	         */   
}
}