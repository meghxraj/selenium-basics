package basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChildWindows {
	public static void main(String[] args) {
		
		WebDriver driver =WebDriverManager.chromedriver().create();
		//WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String ParentID =it.next();
		String ChildID = it.next();
		
		driver.switchTo().window(ChildID);
		String emailID=driver.findElement(By.xpath("//ul[@class='clearfix']/li")).getText();
		//String emailID=driver.findElement(By.xpath("//span[@class='icon fa fa-envelope']")).getText();
		System.out.println(emailID);
		emailID = emailID.split(".com")[0];
		emailID= emailID.split("@")[1];
		System.out.println(emailID);
		driver.close();
		driver.switchTo().window(ParentID);
		driver.findElement(By.id("username")).sendKeys(emailID);
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.id("signInBtn")).click();
	}
	
}
