package org.test.flipkart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends ReferClass{
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="q")
	private WebElement searchTxt;
	public WebElement getSearchTxt() {
		return searchTxt;
	}
	
}
