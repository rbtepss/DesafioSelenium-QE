package obj;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverPage {

	private static String pathDriver = System.getProperty("user.dir") + File.separator + "drivers" + File.separator
			+ "chromedriver.exe";
	protected static WebDriver driver;

	public WebDriver setup() {
		System.setProperty("webdriver.chrome.driver", pathDriver);
		WebDriver driver = new ChromeDriver();
		return driver;

	}

}
