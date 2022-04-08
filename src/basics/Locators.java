package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//adding implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.id("inputUsername")).sendKeys("test");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademytest");
		//driver.findElement(By.id("chkboxOne")).click();
		//driver.findElement(By.name("chkboxOne")).click();
		driver.findElement(By.className("signInBtn")).click();
	
		String errorMsg =driver.findElement(By.cssSelector("p.error")).getText();
		
		/*
		 * syntax for using cssSelectors -> classname -> tagname.classname id ->
		 * tagname#id generic -> tagname[attribute='value']
		 * using with index -> tagname[attribute='value']:nth-child(index)
		 * traversing from parent to child -> parentTagName childTagname
		 * regex -> tagname[attribute*='value']
		 */
		System.out.println(errorMsg);
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		/*
		 * syntax for using xpath -> //tagname[@attribute='value']
		 * using with index //tagname[@attribute='value'][index]
		 * traversing in the parent to child attributes -> //parentTagName/childtagName[index]
		 * regex -> //tagname[contains(@attribute,'value')]
		 * using text-> //tagname[text()='value']
		 * 
		 * Note: in xpath //tagname can also be written as //*
		 */
		
		//selecting locator using index
		
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("megharaj");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("maggie.test@gmail.com");
		//indexing with xpath
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		
		//indexing with cssSelector
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("test@email.com");
		
		//travesing from parent to child node
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9876543210");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String tempPassword =driver.findElement(By.cssSelector("p.infoMsg")).getText();
		tempPassword = tempPassword.split("'")[1];
		tempPassword = tempPassword.split("'")[0];
		
		System.out.println(tempPassword);
		String testname = "testing";
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
		driver.findElement(By.id("inputUsername")).sendKeys(testname);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(tempPassword);
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(2000);
		String loggedIn =driver.findElement(By.tagName("p")).getText();
		Assert.assertEquals(loggedIn, "You are successfully logged in.");
		String usernameLogin =driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
		Assert.assertEquals(usernameLogin, "Hello "+testname+",");
		
		driver.findElement(By.className("logout-btn")).click();
		driver.quit();
		
		
		
		
		
	}

}
