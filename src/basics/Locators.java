package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.id("inputUsername")).sendKeys("test");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademytest");
		//driver.findElement(By.id("chkboxOne")).click();
		//driver.findElement(By.name("chkboxOne")).click();
		driver.findElement(By.className("signInBtn")).click();
		String errorMsg =driver.findElement(By.cssSelector("p.error")).getText();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(errorMsg);
		driver.quit();
		
	}

}
