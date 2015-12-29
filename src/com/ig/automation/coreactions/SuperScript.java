package com.ig.automation.coreactions;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.ig.automation.utility.Log;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import org.apache.log4j.xml.DOMConfigurator;


public class SuperScript {

	public static WebDriver driver;
	// LoginScreen loginScreen = new LoginScreen();

	private String baseUrl;

	@Parameters("browser")
	public void startDriver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("chrome.switches", Arrays.asList("--disable-popup-blocking", "--always-authorize-plugins"));
			// ChromeOptions chromeOptions = new ChromeOptions();
			// chromeOptions.addArguments("--always-authorize-plugins=true");
			// Map<String, Object> prefs = new HashMap<String, Object>();
			// prefs.put("profile.default_content_settings.plug-in", 1);
			driver = new ChromeDriver(caps);
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "lib/IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability("ignoreZoomSetting", true);
			// Setting attribute nativeEvents to false enable click button in IE
			caps.setCapability("nativeEvents",false);
			driver = new InternetExplorerDriver(caps);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void startDriver() {
		//System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		//DesiredCapabilities caps = DesiredCapabilities.chrome();
		//caps.setCapability("chrome.switches", Arrays.asList("--disable-popup-blocking", "--always-authorize-plugins"));

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void getURL() throws Exception {
		DataActions.createConnection();
		baseUrl = DataActions.url;
	}

	public void launchUrl() throws Exception {
		startDriver();
		getURL();
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	public WebElement findElement(By by) {
		try {
			WebElement element = driver.findElement(by);
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void WaitForPageToLoad(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10); // you can reuse this one
		isElementPresent(locator);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	@DataProvider(name = "docData")
	// reading data from excel.
	public Object[][] createData() throws Exception {
		Object[][] retObjArr = DataActions.getTableArray("src\\com\\ig\\automation\\testdata\\DocData.xls", "Sheet1", "CreateDocStart", "CreateDocEnd");
		return (retObjArr);
	}

	public static void writeCSV(String args) throws Exception {
		String csv = "src\\com\\ig\\automation\\testdata\\docid.csv";
		CSVWriter writer = new CSVWriter(new FileWriter(csv, true));

		writer.writeNext(args);

		writer.close();
	}

	public List<String[]> readCSV() throws Exception {
		String csv = "src\\com\\ig\\automation\\testdata\\docid.csv";
		CSVReader reader = new CSVReader(new FileReader(csv));
		List<String[]> docList = reader.readAll();
		reader.close();
		return docList;
	}

	public void getScreenShot(String Folder, String FileName) throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("screenshot\\" + Folder + "\\" + FileName + ".jpeg"));
	}

	public static WebElement waitForElementToAppear(WebDriver webDriver, String id) {
		WebDriverWait wait = new WebDriverWait(webDriver, 20);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}

	public static WebElement waitForElementToAppearxPath(WebDriver webDriver, String xpath) {
		WebDriverWait wait = new WebDriverWait(webDriver, 20);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public static WebElement waitForElementToAppearClassName(WebDriver webDriver, String className) {
		WebDriverWait wait = new WebDriverWait(webDriver, 20);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
	}
	
	public String getFutureDate(int noofdays) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		// get current date time with Date()
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, noofdays);
		dt = c.getTime();
		System.out.println(dateFormat.format(dt));
		return dateFormat.format(dt);
	}

	public void pageScrollDown() {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
	}

	public void assertEquals(boolean booleanActual, boolean booleanExpected, String expectedMessage, String actualMessage) {
		try {
			Assert.assertEquals(booleanActual, booleanExpected);
		} catch (Throwable e) {
			Log.info("Expected Is :" + expectedMessage + "Actual Is :" + expectedMessage);
			Log.info("Error : Failed while Trying to verify information .");
		}
	}

	public void assertTrue(boolean condition, String expectedMessage, String actualMessage) {
		try {
			Assert.assertTrue(condition);
		} catch (Exception e) {
			Log.info("Expected Is :" + expectedMessage + "Actual Is :" + expectedMessage);
			Log.info("Error : Trying to verify information .");
		}
	}
	
	public void assertTrue(boolean condition, boolean expectedMessage, boolean actualMessage) {
		try {
			Assert.assertTrue(condition);
		} catch (Exception e) {
			Log.info("Expected Is :" + expectedMessage + "Actual Is :" + expectedMessage);
			Log.info("Error : Trying to verify information .");
		}
	}
	
	public void assertFalse(boolean condition, String expectedMessage, String actualMessage) {
		try {
			Assert.assertFalse(condition);
		} catch (Exception e) {
			Log.info("Expected Is :" + expectedMessage + "Actual Is :" + expectedMessage);
			Log.info("Error : Trying to verify information .");
		}
	}
	
	public void assertFalse(boolean condition, boolean expectedMessage, boolean actualMessage) {
		try {
			Assert.assertFalse(condition);
		} catch (Exception e) {
			Log.info("Expected Is :" + expectedMessage + "Actual Is :" + expectedMessage);
			Log.info("Error : Trying to verify information .");
		}
	}
	public void selectPreviousDate(String date){
			try {
				driver.findElement(By.cssSelector(".glyphicon.glyphicon-chevron-left")).click();
							 driver.findElement(By.xpath("//*[contains(@class,'calender_frmt')]//*[contains(text(),'"+date+"')]")).click();
			} catch (Exception e) {
				Log.info("Error : While Trying to select Date .");
			}
		}
	
	public void selectFutureDate(String date){
		try {
			driver.findElement(By.cssSelector(".glyphicon.glyphicon-chevron-right")).click();
						 driver.findElement(By.xpath("//*[contains(@class,'calender_frmt')]//*[contains(text(),'"+date+"')]")).click();
		} catch (Exception e) {
			Log.info("Error : While Trying to select Date .");
		}
	}

	public boolean retryingFindClick(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 5) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

}
