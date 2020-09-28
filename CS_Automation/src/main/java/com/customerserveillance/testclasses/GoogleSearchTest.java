package com.customerserveillance.testclasses;

import java.io.IOException;

import org.testng.annotations.Test;

import com.customerserveillance.baseclasses.GoogleSearchBase;
import com.customerserveillance.util.TestCaseBase;

public class GoogleSearchTest extends TestCaseBase {
	
@Test
public void searchBoxTest() throws IOException, InterruptedException {
	GoogleSearchBase obj=new GoogleSearchBase(pageManager);
	pageManager.navigate("https://www.google.com");
	
	String actualTitle = pageManager.getTitle();
	String expectedTitle = "Google";
	customAssertion.assertEquals(actualTitle, expectedTitle);
	
	obj.searchBox();
}
}
