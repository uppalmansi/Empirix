package propertyReader;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {

	private static boolean root = false;

	/**
	 * Logger is a class in the org.apache.log4j.* package. We have to initialize
	 * one Logger object for each Java class
	 */
	public static Logger getLogger(Class cls) {
		if (root) {
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure(
				"C:\\Users\\acer\\eclipse-workspace\\EmpirixCloudPlatform\\src\\test\\java\\configFiles\\log4j.properties");
		root = true;
		return Logger.getLogger(cls);
	}

	public static void main(String[] args) {
		Logger log = LoggerHelper.getLogger(LoggerHelper.class);
		log.info("logger is configured");
		log.info("logger is configured");
		log.info("logger is configured");
	}
}
