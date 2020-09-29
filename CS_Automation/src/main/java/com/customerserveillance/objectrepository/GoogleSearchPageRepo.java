package com.customerserveillance.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.customerserveillance.util.PageManager;
import com.customerserveillance.util.PageObject;

public class GoogleSearchPageRepo extends PageObject{

	public GoogleSearchPageRepo(PageManager pm) {
		super(pm);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@class ='gLFyf gsfi']")
	protected WebElement searchBox;
}
