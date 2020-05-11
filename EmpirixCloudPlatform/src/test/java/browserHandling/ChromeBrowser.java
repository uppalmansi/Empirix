package browserHandling;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeBrowser {

	public ChromeOptions getChromeOptions() {
		ChromeOptions option = new ChromeOptions();
		// option.addArguments("--incognito");
		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");
		//option.addArguments("--incognito");

		DesiredCapabilities chrome = new DesiredCapabilities();
		chrome.setJavascriptEnabled(true);
		option.setCapability(ChromeOptions.CAPABILITY, chrome);

		
		return option;
	}

	public ChromeDriver getChromeDriver(ChromeOptions opt) {

		if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\acer\\eclipse-workspace\\EmpirixCloudPlatform\\src\\drivers\\chromedriver.exe");
			return new ChromeDriver(opt);

		}
		return null;
	}

}
