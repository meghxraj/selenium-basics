package basics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesFileDemo {
	public static void main(String[] args) throws Exception {
		Properties pro = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Megharaj\\workspace\\selenium-basics\\data.properties");
		pro.load(file);
		System.out.println(pro.getProperty("browser"));
		System.out.println(pro.getProperty("url"));
		pro.setProperty("browser", "chromium");
		System.out.println(pro.getProperty("browser"));
		
		//to save the changes the in the file
		FileOutputStream op = new FileOutputStream("C:\\Users\\Megharaj\\workspace\\selenium-basics\\data.properties");
		pro.store(op, "tets");
	}

}
