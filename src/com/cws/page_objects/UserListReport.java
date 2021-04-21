package com.cws.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cws.main.Base;

public class UserListReport extends Base {
	
	public WebElement userListReportTab() {
		return getDriver().findElement(By.xpath("//a[contains(text(),'User List Report')]"));
	}

}
