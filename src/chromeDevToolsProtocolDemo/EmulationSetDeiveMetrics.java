package chromeDevToolsProtocolDemo;

import java.time.Duration;
import java.util.*;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

//Chrome DevTools Protocols are used to access the chrome dev tools and perform actions on them
//CDP is derived from the Chromium based browsers and works only on chromium -Chrome and Edge

public class EmulationSetDeiveMetrics {
	public static void main(String[] args) {
		// here the driver object is of type ChromeDriver and not webdriver as usual
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		/*
		 * devTools.send(Emulation.setDeviceMetricsOverride(375, 667, 75, true,
		 * Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
		 * Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		 */
		// to send the cdp commands directly with out using devtools
		
		  Map<String,Object> map = new HashMap<String,Object>(); 
		  map.put("width", 375);
		  map.put("height", 667);
		  map.put("deviceScaleFactor", 50);
		  map.put("mobile", true);
		 driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", map);
		 
//this will directly interact with cdp
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.className("navbar-toggler-icon")).click();
		driver.findElement(By.xpath("//a[text() ='Library']")).click();
	}

}
