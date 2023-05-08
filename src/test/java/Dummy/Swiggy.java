package Dummy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Swiggy {

	@Test(groups = "smoke")
	public static void swiggy() {

		System.out.println("swiggy");
 		WebDriverManager.chromedriver().setup();
 		WebDriver driver=new ChromeDriver();
 		driver.manage().window().maximize();
 		driver.get("https:www.swiggy.com");
 		System.out.println("swiggy");
	}
}
