package chromeDevToolsProtocolDemo;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v102.network.Network;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkSpeed {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		
		devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 10000, Optional.empty()));

		  driver.get("https://google.com");
		  driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
	}

}
