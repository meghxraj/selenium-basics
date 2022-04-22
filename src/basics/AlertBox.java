package basics;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertBox {
	public static void main(String[] args) {
		ChromeOptions capability = new ChromeOptions();
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(capability);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.id("name")).sendKeys("Megharaj");
		driver.findElement(By.id("alertbtn")).click();

		// switch to alert

		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		// confirm or cancel alert
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();

		//driver.quit();

	}

}
