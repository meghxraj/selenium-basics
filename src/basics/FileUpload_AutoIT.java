package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload_AutoIT {
	
	//use AutoIT to create a script to upload the file and save the file with .au3 extension
	//to generate the script use - scite.exe tool and au3Info_x64 for object spy
	//then complie the .au3 file, which will convert to .exe file
	public static void main(String[] args) throws Exception {
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://tinywow.com/image/remove-bg");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.className("file-uploads")).click();
		
		//to execute the .exe file we need Runtime 
		String path = System.getProperty("user.dir");
		path = path+"\\FileUpload.exe";
		System.out.println(path);
		Runtime.getRuntime().exec(path);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		
	}

}
