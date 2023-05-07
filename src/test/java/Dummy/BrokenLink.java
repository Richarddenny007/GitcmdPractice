package Dummy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	@Test(groups = "smoke")
	public static void disp() throws MalformedURLException, IOException {

		ChromeOptions op=new ChromeOptions();
		op.addArguments("--start-maximized");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(op);
		//		((JavascriptExecutor)driver).executeScript("window.resizeTo(1024, 768);");
		driver.get("https://www.flipkart.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement link:links)
		{
			String url=link.getAttribute("href");

			System.out.println("-------------");

			if(url==null || url.isEmpty())
			{
				System.out.println("--->url is empty");

				continue;// this iteration will skip and iteration will start (for) because if it is blank we no need to hit url
				//if we will not give continue it will stop here only it will throw nullpointer exception

			}

			HttpURLConnection huc = (HttpURLConnection)(new URL(url).openConnection());//cast  //opening the url connection //Retreaving the response
			huc.connect();        //send the request to the server

			if(huc.getResponseCode()>=400)
			{
				System.out.println(url +"--> is broken");

			}
			else {

			//	System.out.println(url +" is valid");

			}





		}


		driver.quit();




	}

}
