package chromeDevToolsProtocolDemo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDemo {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		DevTools tools = driver.getDevTools();
		tools.createSession();
		
		
	}

}
