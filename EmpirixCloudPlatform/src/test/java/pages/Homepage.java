package pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjectmodel.PageObjects;
import propertyReader.LoggerHelper;

public class Homepage {
	private static WebDriver driver;
	private Logger log = LoggerHelper.getLogger(Homepage.class);

	public Homepage(WebDriver driver) {
		this.driver = driver;
	}

	public static void sendKeys(By loc, String value) {
		wait(loc, 6000);
		click(loc);
		WebElement element = driver.findElement(loc);
		element.sendKeys(value);
	}

	public static void click(By loc) {
		WebElement element = driver.findElement(loc);
		wait(loc, 6000);
		element.click();
	}

	public static void wait(By loc, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(loc));
	}

	public void loginCorrectCredentials() throws InterruptedException {
		log.info("Test Case 1: --starting");
		Thread.sleep(2000);
		wait(PageObjects.username, 3000);
		sendKeys(PageObjects.username, "Qa_newuser3");
		sendKeys(PageObjects.password, "Empirix!");
		click(PageObjects.signIn);
		log.info("Successfully logged in with correct credentials");

	}

	public void changeLanguage() throws InterruptedException {
		Thread.sleep(20000);
		log.info("Test case2: Language will be Changed to Japanese");
		click(PageObjects.acceptCookie);
		Thread.sleep(10000);
		click(PageObjects.profiledropdown);
		Thread.sleep(4000);
		click(PageObjects.japaneseClick);
		Alert alert = driver.switchTo().alert();
		alert.accept();

		Thread.sleep(4000);
		click(PageObjects.profiledropdown);
		Thread.sleep(4000);
		log.info("Language will be changed to English");
		click(PageObjects.englishClick);

		alert.accept();
	}

	public void AccessAllTabs() throws InterruptedException {

		// Access Tabs in English

		Thread.sleep(20000);
		log.info("Test Case3: Access all 5 available tabs");
		//click(PageObjects.acceptCookie);
		//Thread.sleep(10000);
		click(PageObjects.profiledropdown);
		Thread.sleep(4000);
		click(PageObjects.japaneseClick);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		// click on tabs
		log.info("Japanese is selected and now will click on all 5 tabs of Japanese");
		Thread.sleep(4000);

		click(PageObjects.alertsTab);
		Thread.sleep(6000);
		click(PageObjects.testsTab);
		Thread.sleep(6000);
		click(PageObjects.variablesTab);
		Thread.sleep(6000);
		click(PageObjects.notificationsTab);
		Thread.sleep(10000);

		// Back to English Language
		Thread.sleep(2000);
		click(PageObjects.profiledropdown);
		Thread.sleep(10000);
		click(PageObjects.englishClick);
		// Thread.sleep(4000);
		alert.accept();

		Thread.sleep(8000);
		log.info("Now language is English and will click on all 5 tabs");
		// click on tabs
		click(PageObjects.dashboardTab);
		Thread.sleep(4000);

		click(PageObjects.alertsTab);
		Thread.sleep(4000);
		click(PageObjects.testsTab);
		Thread.sleep(4000);
		click(PageObjects.variablesTab);
		Thread.sleep(4000);
		click(PageObjects.notificationsTab);
		Thread.sleep(4000);
	}

	public void displayInfoFromClientSection() throws InterruptedException {
		
		Thread.sleep(2000);
		log.info("This will click on the client section in profile dropdown");
		click(PageObjects.profiledropdown);
		click(PageObjects.clientInfo);
		Thread.sleep(10000);
		String details = driver.findElement(PageObjects.clientDetails).getText();
		log.info("All fetched details from client section");
		System.out.println(details);
	}
}
