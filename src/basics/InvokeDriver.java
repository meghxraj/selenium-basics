package basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokeDriver {

	public static void main(String[] args) {

		// traditional way of initilizing chrome driver
		/*
		 * String path = "D:\\Leanings\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe";
		 * System.setProperty("webdriver.chrome.driver", path);
		 */

		//for firefox - use gecko driver
		

		// alternatively we can use WebDriverManager libraries to initiate chrome driver
		// which does not need to be downloaded manually
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		driver.manage().window().maximize();
		//driver.quit();
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://facebook.com");
		driver.manage().window().maximize();
		

	}

}
