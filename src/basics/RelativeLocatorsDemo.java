package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorsDemo {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		//above locator
		WebElement nameEditBox = driver.findElement(By.name("name"));
		//to use relative locator we need to have a import package which is static
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		
	}

}
