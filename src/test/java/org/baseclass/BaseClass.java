package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
		WebDriver driver;
		Robot robot;
		Actions actions;
		Alert al;
		TakesScreenshot screenshot;
		File destination;
		JavascriptExecutor executor;
		Select select;
		//Browser Launch
		public void launchBrowser() {
		WebDriver driver = new ChromeDriver();
		}
		//1.URL Launch
		public void launchUrl(String url) {
		driver.get(url);
		}
		//2.Maximize Window
		public void maximizeWindow() {
		driver.manage().window().maximize();
		}
		//3.Get Title from Webpage
		public String getTitle() {
		String title = driver.getTitle();	
		return title;
		}
		//4.Get the URL from the Webpage
		public String getUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
		}
		//5.Close all the Windows
		public void closeBrowser() {
			driver.quit();
		}
		//6.Find Locator using Id
		public WebElement locatorById(String attributeValue) {
		WebElement id = driver.findElement(By.id(attributeValue));
		return id;
		}
		//7.Find Locator using Name
		public WebElement locatorByName(String attributeValue) {
		WebElement name = driver.findElement(By.name(attributeValue));
		return name;
		}
		//8.Find Locator using Id
		public WebElement locatorByClassName(String attributeValue) {
		WebElement className = driver.findElement(By.className(attributeValue));
		return className;
		}
		//9.Find Locator using Xpath
		public WebElement locatorByXpath(String Xpath) {
		WebElement xpath = driver.findElement(By.xpath(Xpath));
		return xpath;
		}
		//10.Insert Text in a Text Box
		public void sendKeys(WebElement element, String text) {
			element.sendKeys(text);
			}
		//11.Click any Button
		public void click(WebElement element) {
			element.click();
			}
		//12.Navigation Command - Go back to the Previous Page
		public void navigateBack() {
		driver.navigate().back();
		}
		//13.Navigation Command - Go to Next Page
		public void navigateForward() {
		driver.navigate().forward();
		}
		//14.Navigation Command - Refresh the WebPage
		public void Refresh() {
			driver.navigate().refresh();
		}
		//15.Get the Text from the WebPage
		public String getText(WebElement element) {
			String text = element.getText();
			return text;
		}
		//16.Get the inserted Value from the WebPage
		public String getAttribute(WebElement element, String name) {
		String attribute = element.getAttribute(name);
		return attribute;
		}
		//17.Mouse Over Actions - Move to Element
		public void moveToElement(WebElement element) {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).perform();
		}
		//18.Drag and Drop
		public void dragAndDrop(WebElement source, WebElement destination) {
			Actions actions = new Actions(driver);
			actions.dragAndDrop(source, destination).perform();
			}
		//19.Double Click
		public void doubleClick(WebElement element) {
			Actions actions = new Actions(driver);
			actions.doubleClick(element).perform();
			}
		//20.Right Click
		public void contextClick(WebElement element) {
			actions = new Actions(driver);
			actions.contextClick(element).perform();
			}
		//21.Keyboard Actions using Actions Class
		public void actinsByKeyboard(CharSequence key,CharSequence text) {
			actions = new Actions(driver);
			actions.keyDown(key).sendKeys(text).keyUp(key).perform();
		}
		//22.Switch to Alert Tab
		public void switchAlert() {
			al = driver.switchTo().alert();
		}
		//23.Click ok in Alert Tab
		public void simpleAlert() {
			al.accept();
		}
		//24.Click dismiss in Alert Tab
		public void confirmAlert() {
			al.dismiss();
		}
		//25.Insert text in alert text box
		public void promptAlert(String text) {
			al.sendKeys(text);
		}
		//26.Take Screenshot
		public File takeScreenshot(String pathName) throws IOException {
			screenshot = (TakesScreenshot) driver;
			File  source= screenshot.getScreenshotAs(OutputType.FILE);
			destination = new File(pathName);
			FileUtils.copyFile(source, destination);
			return source;
		}
		//27.Insert Values using JavaScript
		public void insertJavaScript(WebElement element, String text) {
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].setAttribute('value','"+text+"')",element);
		}
		//28.Click using JavaScript
		public void clickJavaScript(WebElement element) {
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click()",element);
		}
		//29.Get the text using JavaScript
		public Object getTextJavaScript(WebElement element) {
			executor = (JavascriptExecutor) driver;
			Object text = executor.executeScript("return arguments[0].getAttribute('value')",element);
			return text;
		}
		//30.ScrollDown using JavaScript
		public void scrollDown(WebElement element) {
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true)",element);
		}
		//31.ScrollUp using JavaScript
		public void scrollUp(WebElement element) {
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(false)",element);
		}
		//32.Select DropDown using Index
		public void selectByIndex(WebElement element, int index) {
			select = new Select(element);
			select.selectByIndex(index);
		}
		//33.Select DropDown using Attribute Value
		public void selectByValue(WebElement element, String value) {
			select = new Select(element);
			select.selectByValue(value);
		}
		//34.Select DropDown using Text
		public void selectbyText(WebElement element, String text) {
			select = new Select(element);
			select.selectByVisibleText(text);
		}
		//35.Get all the options from DropDown
		public List<WebElement> AllOptions() {
			List<WebElement> options = select.getOptions();
			return options;
		}
		//36.Get all Selected Options from DropDown
		public List<WebElement> AllSelectedOptions() {
			List<WebElement> SelectedOptions = select.getAllSelectedOptions();
			return SelectedOptions;
		}
		//37.Get First Selected Option from DropDown
		public WebElement firstSelectedOption() {
			WebElement element = select.getFirstSelectedOption();
			return element;
		}
		//38.Deselect Value in DropDown using Index
		public void deselectByIndex(WebElement element, int index) {
			select = new Select(element);
			select.deselectByIndex(index);
		}
		//39.Deselect Value in DropDown using Attribute Value
		public void deselectByValue(WebElement element, String value) {
			select = new Select(element);
			select.deselectByValue(value);
		}
		//40.Deselect Value in DropDown using Text
		public void deselectByText(WebElement element, String text) {
			select = new Select(element);
			select.deselectByVisibleText(text);
		}
		//41.Deselect all Values in DropDown
		public void deselectAll(WebElement element) {
			select = new Select(element);
			select.deselectAll();
		}
		//42.Check whether DropDown is a Multi Selection DropDown
		public boolean multiselectionDropDown(WebElement element) {
			select = new Select(element);
			boolean multiple = select.isMultiple();
			return multiple;
		}
		//43.Switch to Frame using FrameId or FrameName
		public void frameId(String id) {
			driver.switchTo().frame(id);
		}
		//44.Switch to Frame using WebElement
		public WebElement frameWebElement(String xpath) {
			WebElement element = driver.findElement(By.xpath(xpath));
			driver.switchTo().frame(element);
			return element;
		}
		//45.Switch to Frame using Index
		public void frameIndex(int index) {		
			driver.switchTo().frame(index);
		}
		//46.Get the Frames Count
		public Integer frameCount(String tagName) {
			List<WebElement> elements = driver.findElements(By.tagName(tagName));
			int size = elements.size();
			System.out.println(size);
			return size;
		}
		//47.Read the data from Excel
		public String readData(String sheetName, int rowIndex, int cellIndex, String oldData, String newData) throws IOException {
			String ref=null;
			File file = new File("path");
			FileInputStream stream = new FileInputStream(file);
			Workbook book = new XSSFWorkbook(stream);
			Sheet sheet = book.getSheet(sheetName);
			Row row = sheet.getRow(rowIndex);
			Cell cell = row.getCell(cellIndex);
			CellType type = cell.getCellType();
			switch (type) {
			case STRING: 
				String text = cell.getStringCellValue();
				ref = text;
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date d = cell.getDateCellValue();
					SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
					String date = format.format(d);
					ref = date;
				} 
				else {
					double numeric = cell.getNumericCellValue();
					BigDecimal big = BigDecimal.valueOf(numeric);
					String number = big.toString();
					ref = number;
				}
			default:
				break;
			}
			return ref;
		}
		//48.Update the 
	}
