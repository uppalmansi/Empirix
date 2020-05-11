package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.Homepage;
import propertyReader.ObjectReader;

public class TestCases extends Testbase {

	Homepage homepage;

	@Test(priority = 1)
	public void TC_01_Login_With_Correct_Credentials() throws InterruptedException {
		getApplicationURL(ObjectReader.reader.getUrl());
		Thread.sleep(5000);
		homepage = new Homepage(driver);
		homepage.loginCorrectCredentials();
	}

	@Test(priority = 2)
	public void TC_02_Change_Language() throws InterruptedException {
		homepage = new Homepage(driver);
		homepage.changeLanguage();
	}
	
	@Test(priority=3)
	public void TC_03_Access_All_Tabs() throws InterruptedException {
		homepage = new Homepage(driver);
		homepage.AccessAllTabs();
	}
	
	@Test(priority=4)
	public void TC_04_Display_Client_Info() throws InterruptedException {
		homepage = new Homepage(driver);
		homepage.displayInfoFromClientSection();
	}

}
