package elmhurst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhpTravels {
	public static void main(String[] args) throws InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		 
		 WebDriver boy = new ChromeDriver();
		 
		 boy.get("https://www.phptravels.net/login");
		 //boy.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		System.out.println(boy.getTitle());
		boy.manage().window().maximize();
		 
		 boy.findElement(By.name("username")).sendKeys("user@phptravels.com");
		 boy.findElement(By.name("password")).sendKeys("demouser");
		 boy.findElement(By.id("loginfrm")).click();
		 //Thread.sleep(3000);
	}
		
	}
		 
