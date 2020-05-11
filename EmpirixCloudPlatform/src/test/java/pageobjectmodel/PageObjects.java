package pageobjectmodel;

import org.openqa.selenium.By;

public class PageObjects {

	public static By username = By.xpath("//input[@name='callback_0']");
	public static By password = By.xpath("//input[@name='callback_1']");
	public static By signIn = By.xpath("//input[@name='callback_2']");
	public static By acceptCookie= By.xpath("//a[contains(text(),'Got it!')]");
	public static By profiledropdown = By.xpath("//a[contains(text(),'qa_newuser3(Empirix_QA_Training)')]");
	public static By japaneseClick = By.xpath("//a[contains(text(),'Japanese')]");
	public static By englishClick = By.xpath("//a[contains(text(),'English')]");
	public static By dashboardTab= By.xpath("(//div[@class='container'])[2]//li[1]");
	public static By alertsTab= By.xpath("(//div[@class='container'])[2]//li[4]");
	public static By testsTab= By.xpath("(//div[@class='container'])[2]//li[5]");
	public static By variablesTab= By.xpath("(//div[@class='container'])[2]//li[14]");
	public static By notificationsTab= By.xpath("(//div[@class='container'])[2]//li[16]");	
	public static By clientInfo= By.xpath("//span[contains(text(),'Client')]");
	public static By clientDetails= By.xpath("//div[@class='col-sm-6']");
}
