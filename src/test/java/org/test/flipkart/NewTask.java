package org.test.flipkart;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.openqa.selenium.WebElement;

public class NewTask extends ReferClass {
	public static void pageTask() {
		ContentPage c=new ContentPage();
		List<Integer> li=new LinkedList<>();
		List<WebElement> pdt = c.getProducts();
		System.out.println("An Available Products in this Page is: ");
		for(int i=0;i<pdt.size();i++)
		{
			System.out.println(pdt.get(i).getText());
		}
		List<WebElement> priceList = c.getPriceList();
		System.out.println("\n"+"Rates of the Available Products are:");
		for(int j=0;j<priceList.size();j++) {
			System.out.println(priceList.get(j).getText());
		}	
		String s="";
		for(int j=0;j<priceList.size();j++) {
			String text = priceList.get(j).getText();
			if(text.contains("₹")) {
				String re = text.replace("₹", "");
				 s = re.replace(",", "");
			}
			int pl = Integer.parseInt(s);
			li.add(pl);
		}
		Collections.sort(li);
		System.out.println("\n"+"The Minimum Price is:"+"₹"+li.get(0));
		System.out.println("\n"+"The Maximum Price is:"+"₹"+li.get(li.size()-1));
		Map<String, String> mp=new LinkedHashMap<>();
		for(int i=0;i<pdt.size();i++)
		{
			for(int j=0;j<priceList.size();j++) {
				if(i==j) {
					mp.put(pdt.get(i).getText(),priceList.get(j).getText());	}}}
		Set<Entry<String, String>> total = mp.entrySet();
		System.out.println("======Product=======Price=======");
		for (Entry<String, String> x : total) {
			System.out.println(x);
		}
	}	
}
