package org.test.flipkart;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContentPage extends ReferClass{
	public ContentPage() {
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class=\"_4rR01T\"]")
	private List<WebElement> products;
	
	@FindBy(xpath="//div[@class=\'_30jeq3 _1_WHN1\']")
	private List<WebElement> priceList;
	@FindBy(xpath="(//a[@class='ge-49M'])[1]")
	private WebElement secondPage;
	@FindBy(xpath="(//a[@class='ge-49M'])[2]")
	private WebElement thirdPage;
	
	public WebElement getThirdPage() {
		return thirdPage;
	}

	public List<WebElement> getPriceList() {
		return priceList;
	}
	
	public WebElement getSecondPage() {
		return secondPage;
	}

	public List<WebElement> getProducts() {
		return products;
	}
	
	
	
}
