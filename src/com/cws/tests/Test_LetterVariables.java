package com.cws.tests;

import java.util.Random;

import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cws.commons.CommonFunctions;
import com.cws.page_objects.LetterVariables;
import com.cws.utils.Reports;
import com.cws.utils.Screenshot;

public class Test_LetterVariables extends LetterVariables {
	
	CommonFunctions cf = new CommonFunctions();
	ExtentTest letterVariables; 
	
	public int getRandomNumberUsingNextInt(int userMin, int userMax) {
	    Random random = new Random();
	    int finalValue = (random.nextInt(userMax - userMin) + userMin + 3) + (random.nextInt(userMax - userMin) + userMin + 1); 
	    return finalValue;
	}
	
	public void changeCFLTo(String value, ExtentTest result) {
		Select dailyCFL = new Select(dailyCFLTo());
		dailyCFL.selectByValue(value);
		result.log(Status.PASS, "Selected 'Daily CFL To' value: "+value);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		
		equityCFLFrom().clear();
		String dataEquity = "QA"+getRandomNumberUsingNextInt(10, 100);
		equityCFLFrom().sendKeys(dataEquity);
		result.log(Status.PASS, "Changed 'Equity CFL From' value: "+dataEquity);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		
		equityDivCtrlMgr().clear();
		String dataEqCtrl = "Automation"+getRandomNumberUsingNextInt(20, 200);
		equityDivCtrlMgr().sendKeys(dataEqCtrl);
		result.log(Status.PASS, "Changed 'Equity Div Control Manager' value: "+dataEqCtrl);
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		
		submitBtn().click();
		cf.sleepWait(1000);
		result.log(Status.PASS,"Clicked on Submit button");
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		closeBtn().click();
		result.log(Status.PASS,"Clicked on Close button");
		cf.sleepWait(1000);
	}
	
	public void validate_letterVariablesPage() {
		letterVariables = Reports.extent.createTest("Letter Variables", "Validate Letter Variables page");
		letterVariablesTab().click();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		changeCFLTo("CIT", letterVariables);
		changeCFLTo("BNY", letterVariables);
		
	}

}
