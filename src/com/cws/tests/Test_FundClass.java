package com.cws.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.cws.commons.CommonFunctions;
import com.cws.page_objects.FundClass;

public class Test_FundClass extends FundClass {
	
	CommonFunctions cf = new CommonFunctions();
	
	public void validate_fundClassPage() {
		fundClassTab().click();
		cf.sleepWait(1500);
		fundClassTextbox().click();
		cf.sleepWait(1500);
		fundClassTextbox().sendKeys("qwer");
		Actions act = new Actions(getDriver());
		act.sendKeys(Keys.ENTER).build().perform();
		cf.sleepWait(1500);
	}

}
