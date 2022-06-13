package chromeDevToolsProtocolDemo;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v102.network.Network;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkDemo {

	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//+WebDriver driver = new ChromeDriver();
		DevTools tools = driver.getDevTools();
		tools.createSession();

		// enable the network tab logging
		// parameters are to define the max and min of logging
		tools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		// addding listeners to monitor the requests and resposne

		// handelling the request
		tools.addListener(Network.requestWillBeSent(), request -> {
			System.out.println("Request getMethod --"+request.getRequest().getMethod());
			request.getRequestId().
			System.out.println("Request getURL--"+request.getRequest().getUrl());
			System.out.println(request.getRequest().getHeaders());
		});

		// handelling the response
		tools.addListener(Network.responseReceived(), response -> {
			System.out.println("Response --"+response.getResponse().getStatus());
			System.out.println(response.getResponse());
		});

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

	}
}
