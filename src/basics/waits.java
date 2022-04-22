
package basics;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class waits {

		/*
		 * Implicit Wait 
		 * 1. When declared globally it is Implicit Wait 
		 * 2. for each step implicit wait is applied 
		 * 3. will wait for dom to load the property 
		 * 4. will not wait for the entire specified time, will resume execution when element is displayed 
		 * 5. willfail if it exceeds specified wait
		 */
		
		/*
		 * Explicit wait 
		 * 1. is used when we have to add extra wait for some scenarios
		 * 2. Two types - Webdriver wait and fluent wait
		 * 
		 * WebDriverWait ->
		 * Webdriver wait monitors the dom and listens to the dom element in miliseconds
		 * 
		 * WebDriverWait wait = new WebdriverWait(driver,<time>);
		 * wait.until(ExpectedConditions.<action>);
		 *
		 * Fluent wait ->
		 * Fluent wait find the element repeatedly at regular intervals of time - need to specify the polling time
		 * 
		 * Wait<WebDriver> wait = new FluentWait<WebDriver>()
		 * 	.withTimeout(maxTime)
		 * 	.pollingEvery(pollingTime)
		 * 	.ignoring(Exceptions);
		 * 
		 *After this we need to define custom methods
		 *
		 *WebElement foo =wait.until(new Function <WebDriver,WebElement>(driver){
		 *	public WebElement apply(WebDriver driver){
		 *		return driver.findElement(By.locator(""));
		 *	}
		 *}
		 */
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		
		
		//fluent wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		WebElement element =wait.until(new Function<WebDriver,WebElement>(){
			@Override
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed())
					return driver.findElement(By.xpath("//div[@id='finish']/h4"));
				else
					return null;
			}
		});
		System.out.println(element.getText());
		
		driver.quit();
		
	}

}
