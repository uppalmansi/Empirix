package tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import browserHandling.BrowserType;
import browserHandling.ChromeBrowser;
import browserHandling.FirefoxBrowser;
import propertyReader.LoggerHelper;
import propertyReader.ObjectReader;
import propertyReader.PropertyReader;

public class Testbase {

	public WebDriver driver;
	private Logger log = LoggerHelper.getLogger(Testbase.class);

	@BeforeMethod
	public void beforeMethod(Method method) {
		log.info("----Starting");

	}

	@BeforeTest
	public void beforeTest() throws Exception {
		ObjectReader.reader = new PropertyReader();

		setUpDriver(ObjectReader.reader.getBrowserType());
		Thread.sleep(2000);
	}

	@AfterTest
	public void afterTest() {
		/*
		 * if (driver != null) driver.quit();
		 */
	}

	public void setUpDriver(BrowserType btype) throws Exception {
		driver = getBrowserObject(btype);
		log.info("Initialize web driver: " + driver.hashCode());
		Thread.sleep(2000);
		driver.manage().window().maximize();
	}

	public WebDriver getBrowserObject(BrowserType btype) throws Exception {
		try {
			switch (btype) {
			case Chrome:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				ChromeOptions option = chrome.getChromeOptions();
				return chrome.getChromeDriver(option);

			/*case Firefox:
				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				FirefoxOptions options = firefox.getFirefoxOptions();
				return firefox.getFirefoxDriver(options);*/

			/*
			 * case IE: IEBrowser ie = IEBrowser.class.newInstance(); IEOptions
			 * cap=ie.getIEOptions(); return ie.getIEDriver(cap);
			 */

			default:
				throw new Exception("Driver not found " + btype.name());
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	public void getApplicationURL(String url) throws InterruptedException {
		driver.get(url);
		// Thread.sleep(2000);

	}

}
