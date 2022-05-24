package basics;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptionsDemo {
	public static void main(String[] args) {
		
		//ChromeOptions (Options for ChromeBrowser only) is used to accept browser level arguments
		//like accepting ssl certificates, adding extension etc.
		
		
		//accepting insecure certifications - after setting the options, pass the options as argument in driver initilization
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		/*
		 * //adding extensions to the browser //give the path of the extension as
		 * argument 
		 * options.addEncodedExtensions(new File("path"));
		 */
		
		/*
		 * //setting proxies Proxy proxy = new Proxy();
		 * proxy.setHttpProxy("ipaddress:444"); 
		 * options.setCapability("proxy", proxy);
		 */
		//disabling popups (location, camera)
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		
	
		WebDriver driver =WebDriverManager.chromedriver().capabilities(options).create();
		//WebDriver driver = new ChromeDriver();
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		/*
		 * //delete all cookies driver.manage().deleteAllCookies(); //delete specific
		 * cookie or delete session cookie
		 * 
		 * driver.manage().deleteCookieN
		 * amed("cookie name"); //add cookie
		 * driver.manage().addCookie(null);
		 */
		//take screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\Users\\Megharaj\\Downloads\\selenium-screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
