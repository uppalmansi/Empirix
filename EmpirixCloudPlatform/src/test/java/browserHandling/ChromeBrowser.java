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
		
		DesiredCapabilities chrome = new DesiredCapabilities();
		chrome.setJavascriptEnabled(true);
		option.setCapability(ChromeOptions.CAPABILITY, chrome);

		
		return option;
	}

	public ChromeDriver getChromeDriver(ChromeOptions opt) {

		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\acer\\git\\EmpirixRepo\\EmpirixCloudPlatform\\src\\drivers\\chromedriver.exe");
			return new ChromeDriver(opt);

		}
		return null;
	}

}
