package Dummy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazonTest {


	@Test(groups = "smoke")
	public static void hkl() {
		System.out.println("test@1amazon");
		WebDriverManager.chromedriver().setup();

		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--start-maximized");

		WebDriver driver=new ChromeDriver(opt);
		driver.get("https:www.amazon.com");
           


	}




}

