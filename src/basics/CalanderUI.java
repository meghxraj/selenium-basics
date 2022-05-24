package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CalanderUI {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =WebDriverManager.chromedriver().create();
		//WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("travel_date")).click();
		
		//get a common attribute, add them to the list and iterate
		List<WebElement> element =driver.findElements(By.xpath("//*[@class='day']"));
		
		for(int i =0;i<element.size();i++) {
			if (element.get(i).getText().equalsIgnoreCase("20")){
				element.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
