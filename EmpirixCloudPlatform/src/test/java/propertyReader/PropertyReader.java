package propertyReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import browserHandling.BrowserType;


/**
 * CofigReader is interface containing unimplemented methods. PropertyReader
 * implements ConfigReader and write codes for those unimplemented methods
 * 
 * @author acer
 *
 */
public class PropertyReader implements ConfigReader {

	private static FileInputStream file;
	public static Properties prop;

	public PropertyReader() {

		try {
			String filepath = "C:\\Users\\acer\\eclipse-workspace\\EmpirixCloudPlatform\\src\\test\\java\\configFiles\\config.properties";
			file = new FileInputStream(new File(filepath));
			prop = new Properties();
			prop.load(file);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}


	public BrowserType getBrowserType() {
		return BrowserType.valueOf(prop.getProperty("browserType"));
	}

	public String getUrl() {
		return prop.getProperty("url");
	}

	

}
