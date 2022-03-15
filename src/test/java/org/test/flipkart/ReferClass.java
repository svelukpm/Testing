package org.test.flipkart;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.interactions.touch.Up;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReferClass {
	public static  File f;
	public static WebDriver driver;
	public static Robot r;
	public static Actions a;
	public static JavascriptExecutor js;
	public static Alert al;
	public static Select s;
	
	public static WebDriver browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		return driver;
	}
	public static void urlLanuch(String e) {
		driver.get(e);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}
	public static void send(WebElement e,String a) {
		e.sendKeys(a);
	}
	public static void click(WebElement e) {
		e.click();
	}
	public static String getText(WebElement e) {
		return e.getText();
	}
	public static String getAttribute(WebElement e) {
		return e.getAttribute("value");
	}
	public static void close() {
		driver.close();
	}
	public static void quit() {
		driver.quit();
	}
	public static void sleep(long value) throws InterruptedException {
		Thread.sleep(value);
	}
	public static void esc() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}
	public static void down() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	public static void up() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}
	public static void enter() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void copy() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	public static void paste() throws AWTException {
		r =new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	public static void cut() throws AWTException {
		r =new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	public static Actions move(WebElement target) {
		a=new Actions(driver);
		a.moveToElement(target).perform();
		return a;
	}
	public static void drag(WebElement source,WebElement target) {
		a=new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}
	public static void actionClick(WebElement target) {
		a=new Actions(driver);
		a.click(target).perform();
	}
	public static void rightClick(WebElement target) {
		a=new Actions(driver);
		a.contextClick(target).perform();
	}
	public static void doubleClick(WebElement target) {
		a=new Actions(driver);
		a.doubleClick(target).perform();
	}
	public static File screenShot() throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File srcFile = tk.getScreenshotAs(OutputType.FILE);
		File destFile=new File("C:\\Users\\ELCOT\\eclipse-workspace\\Maven_Exercise\\src\\test\\resources\\Screenshot\\1.png");
		FileUtils.copyFile(srcFile, destFile);
		return f;	
	}
	public static JavascriptExecutor jscGet(WebElement value) {
		js=(JavascriptExecutor)driver;
		js.executeScript("return arguments[0].getAttribute('value')", value);
		return js;	
	}
	public static void jscClick(WebElement value) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", value);
	}
	public static void scrollDown(WebElement value) {
		js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)", value);
	}
	public static void scrollUp(WebElement value) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", value);
	}
	public static void alertApt() {
		al=driver.switchTo().alert();
		al.accept();
	}
	public static void alertDms() {
		al=driver.switchTo().alert();
		al.dismiss();
	}
	public static void alertSend(String value) {
		al=driver.switchTo().alert();
		al.sendKeys(value);	
	}
	public static String alertText() {
		al=driver.switchTo().alert();
		return al.getText();
	}
	public static void frameId(String value) {
		driver.switchTo().frame(value);
	}
	public static void frameName(String value) {
		driver.switchTo().frame(value);
	}
	public static void frameWeb(WebElement e) {
		driver.switchTo().frame(e);
	}
	public static void frameIndex(int e) {
		driver.switchTo().frame(e);
	}
	public static void defaultFrame() {
		driver.switchTo().defaultContent();
	}
	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}
	public static void windowHandles(int index) {
		Set<String> window = driver.getWindowHandles();
		List<String>li=new LinkedList<>();
		li.addAll(window);
		driver.switchTo().window(li.get(index));
	}
	public static void navigate(String e) {
		driver.navigate().to(e);
	}
	public static void back() {
		driver.navigate().back();
	}
	public static void forward() {
		driver.navigate().forward();
	}
	public static void refresh() {
		driver.navigate().refresh();
	}
	public static void selectvalue(WebElement e,String value) {
		s=new Select(e);
		s.selectByValue(value);
	}
	public static void selectVisibleText(WebElement e, String value) {
		s=new Select(e);
		s.selectByVisibleText(value);
	}
	public static void selectIndex(WebElement e,int i) {
		s=new Select(e);
		s.selectByIndex(i);
	}
	public static List<WebElement> selectGetOptions(WebElement e) {
		s=new Select(e);
		List<WebElement> list = s.getOptions();
		return list;
	}
	public static String FirstSelectedOption(WebElement e) {
		s=new Select(e);
		WebElement value = s.getFirstSelectedOption();
		return value.getText();
	}
	
	public static String getExcelValue(String loc,String sheetname,int r,int c) throws IOException {
		File f=new File("C:\\Users\\ELCOT\\Desktop\\"+loc+".xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		Sheet sheet = w.getSheet(sheetname);
		Row row = sheet.getRow(r);
		Cell cell = row.getCell(c);
		int type = cell.getCellType();
		String value=null;
		if(type==1) {
			value = cell.getStringCellValue();
		}
		else {
			if(DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy");
				value = sf.format(date);
			}
			else {
				double db=cell.getNumericCellValue();
				long ln=(long)db;
				value = String.valueOf(ln);
			}
		}
		return value;
	}
	public static void excelUpdate(String name,String sheetname,int r,int c,String value) throws IOException {
		File f=new File("C:\\Users\\ELCOT\\Desktop\\"+name+".xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		Sheet sheet = w.getSheet(sheetname);
		Row row = sheet.getRow(r);
		Cell createCell = row.createCell(c);
		createCell.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(f);
		w.write(fos);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
