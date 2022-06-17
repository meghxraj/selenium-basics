package chromeDevToolsProtocolDemo;

import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAuthentication {

	@Test
	public void  test() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.orgs");
		
		//converting the driver object to selenium HasAuthentication and adding credentials 
		//((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("user", "passwd"));
		//driver.get("http://httpbin.org/basic-auth/user/passwd");
		driver.get("http://user:passwd@httpbin.org/basic-auth/user/passwd");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
