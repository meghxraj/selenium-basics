package basics;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticDropdowns {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement selectDD = driver.findElement(By.xpath("//*[@id='ctl00_mainContent_DropDownListCurrency']"));
		Select dropdown = new Select(selectDD); 
		dropdown.selectByIndex(3);
		Assert.assertEquals("USD", dropdown.getFirstSelectedOption().getText());
		System.out.println(dropdown.getFirstSelectedOption().getText()); //use when there is only one select option 
		//dropdown.getAllSelectedOptions();// use when there are multiple selected options
		dropdown.selectByVisibleText("INR");
		Assert.assertEquals("INR", dropdown.getFirstSelectedOption().getText());
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("AED");
		Assert.assertEquals("AED", dropdown.getFirstSelectedOption().getText());
		System.out.println(dropdown.getFirstSelectedOption().getText());
		driver.quit();
	
	}
}
