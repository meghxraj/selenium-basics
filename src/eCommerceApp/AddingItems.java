package eCommerceApp;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddingItems {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//array having expected list
		List<String> items = Arrays.asList("cucumber", "beetroot", "carrot","mushroom");
		addItems(driver,items);
		
		//click on cart
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		//apply promocode
		driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.promoInfo")));
		
		Assert.assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getText(),"Code applied ..!");
		
		driver.quit();
			
	}
	
	
	//method to add items into cart
	public static void addItems(WebDriver driver,List<String> items) {
		//getting the list of product names
				List<WebElement> products =driver.findElements(By.cssSelector("h4.product-name"));
				/*
				 * products.stream().forEach(p -> {
				 * if(items.contains(p.getText().split("")[0].toLowerCase())) {
				 * driver.findElements(By.xpath("//button[text()='ADD TO CART']")); } });
				 */
				int count =0;
				for(int i=0;i<products.size();i++) {
					//checking if the item name is present in the list
					if(items.contains(products.get(i).getText().split("-")[0].toLowerCase().trim())){
						driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
						count++;
						if(count==items.size())
							break;
					}
				}
	}

}
