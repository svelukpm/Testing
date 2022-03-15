package org.test.flipkart;

import java.awt.AWTException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise extends ReferClass {
	public static void main(String[] args) throws AWTException {
		browserLaunch();
		urlLanuch("https://www.flipkart.com/");
		esc();
		SearchPage sp=new SearchPage();
		ContentPage c=new ContentPage();
		send(sp.getSearchTxt(), "iPhone");
		enter();
		NewTask.pageTask();
		click(c.getSecondPage());
		NewTask.pageTask();
		click(c.getThirdPage());
		NewTask.pageTask();
		close();
	}
}
