package baseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass1 {
	
	static WebDriver driver;

	public static WebDriver getDriver() {
		
		if(driver == null) {
			System.setProperty("webdriver.chrome.driver", "E:\\SOFTWARE TESTING\\Software & Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}	
		
		return driver;
	}

}
