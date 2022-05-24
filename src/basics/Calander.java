package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calander {
	public static void main(String[] args)  {

		// chrome options to handle private connection error
		ChromeOptions capability = new ChromeOptions();
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		WebDriver driver =WebDriverManager.chromedriver().capabilities(capability).create();
		//WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//click on round trip
		//driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
		
		//check if return date is enabled or not
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("Round trip enabled");
			Assert.assertTrue(true);
		}
		else
			System.out.println("Oneway Trip");
		
	}
}
