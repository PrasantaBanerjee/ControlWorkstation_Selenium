package com.cws.commons;

import com.cws.main.Base;

public class CommonFunctions extends Base {

	CommonPageObjects cpo = new CommonPageObjects();

	public void sleepWait(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

}
