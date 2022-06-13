package chromeDevToolsProtocolDemo;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmulationLocationOverride {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		
		//overiding the location
		 Map<String,Object> map = new HashMap<String,Object>(); 
		  map.put("latitude", 52.53);
		  map.put("longitude", 13.48);
		  map.put("accuracy", 50);
		  driver.executeCdpCommand("Emulation.setGeolocationOverride", map);
		  
		  driver.get("https://google.com");
		  driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		  
		
	}

}
