package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsTraversing {

	public static void main(String[] args) {

		WebDriver driver =WebDriverManager.chromedriver().create();
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		
		//adding implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//traversing from parent to child and then child to child -> followig-sibling:: is used to move from child to child
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]//following-sibling::button[2]")).getText());
		
		//to move from child to parent
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]//parent::div/button[2]")).getText());
		driver.quit();
	}

}
