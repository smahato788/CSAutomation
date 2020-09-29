package com.customerserveillance.baseclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.customerserveillance.objectrepository.GoogleSearchPageRepo;
import com.customerserveillance.util.PageManager;
import com.customerserveillance.util.PageObject;

public class GoogleSearchBase extends GoogleSearchPageRepo {
	
	/*@FindBy(xpath="//input[@class ='gLFyf gsfi']")
	WebElement searchBox; */
	
	public GoogleSearchBase(PageManager pm) {
		super(pm);
		// TODO Auto-generated constructor stub
	}
	
	public void searchBox() throws InterruptedException {
		pageManager.sendKeys(searchBox, "selenium");
		Thread.sleep(5000);
	}

}
