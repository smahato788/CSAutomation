package com.customerserveillance.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.support.PageFactory;

import com.customerserveillance.util.PageManager;

public class PageObject {
	
	protected PageManager pageManager;
	
	
		public PageObject(PageManager pm) {
			pageManager = pm;
			PageFactory.initElements(pageManager.getDriver(), this);
		}
		
	
	
}



