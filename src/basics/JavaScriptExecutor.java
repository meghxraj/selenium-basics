package basics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {
	public static void main(String[] args) {

		WebDriver driver =WebDriverManager.chromedriver().create();
		//WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//scrolling browser window
		//to scroll use javascript executor
		JavascriptExecutor js = (JavascriptExecutor) driver;//type casting the driver as js executor
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
	}
}
