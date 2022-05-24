package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndToEndLocators {

	public static void main(String[] args) {
		// chrome options to handle private connection error
		ChromeOptions capability = new ChromeOptions();
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		WebDriver driver =WebDriverManager.chromedriver().capabilities(capability).create();
		//WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// selecting the region/country
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		options.forEach(op -> {
			if (op.getText().equalsIgnoreCase("india")) {
				op.click();
			}
		});

		// click on round trip
		// driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

		// selecting from and to
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();

		// xpath using parent child relationship
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();

		// selecting date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();

		// check if return date is enabled or not
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("Round trip enabled");
			Assert.assertTrue(true);
		} else
			System.out.println("Oneway Trip");

		// adding passangers
		driver.findElement(By.id("divpaxinfo")).click();
		int num = 5;
		for (int j = 1; j < num; j++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		String personCount = driver.findElement(By.id("divpaxinfo")).getText();
		System.out.println(personCount);
		Assert.assertEquals(personCount, num + " Adult");
		
		WebElement selectDD = driver.findElement(By.xpath("//*[@id='ctl00_mainContent_DropDownListCurrency']"));
		Select dropdown = new Select(selectDD); 
		dropdown.selectByVisibleText("INR");
		Assert.assertEquals("INR", dropdown.getFirstSelectedOption().getText());
		
		//click on search
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights']")).click();
		

	}

}
