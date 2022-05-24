package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownWithNumbers {
	public static void main(String[] args) {
		WebDriver driver =WebDriverManager.chromedriver().create();
		//WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("divpaxinfo")).click();
		int num = 5;
		/*
		 * int i =1; while(i<num) { driver.findElement(By.id("hrefIncAdt")).click();
		 * i++; }
		 */
		for(int j=1;j<num;j++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		String personCount = driver.findElement(By.id("divpaxinfo")).getText();
		System.out.println(personCount);
		Assert.assertEquals(personCount, num+" Adult");
		driver.quit();
	}

}
