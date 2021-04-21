package com.cws.tests;

import org.openqa.selenium.support.ui.Select;
import com.cws.page_objects.HalfpennyDetails;
import com.cws.utils.Screenshot;

public class Test_HalfpennyDetails extends HalfpennyDetails {
	public void validate_Details() {
		/*
		halfpenny().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		// Details module
		Details_Btn().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		Export_Btn().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		Submit_Btn().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		Submit_BtnPopup().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");
		Recalculate_Btn().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Recalculate_BtnPopup().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cancel_Btn().click();
		Custodian().click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select Custodianname = new Select(HalfpennyDetails.Custodian());

		Custodianname.selectByVisibleText("BNY");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Export_Btn1().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Submit_Btn1().click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Submit_BtnPopup1().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Recalculate_Btn1().click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Recalculate_BtnPopup1().click();
		Screenshot.captureScreenshot(getDriver(), "Screenshot_");

	}

}
