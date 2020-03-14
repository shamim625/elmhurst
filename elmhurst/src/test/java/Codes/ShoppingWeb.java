package Codes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import screenshot.TakeScreenShot;

public class ShoppingWeb {
	static WebDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor js;
		
		

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		WebElement signin = driver.findElement(By.xpath("//*[contains(text(),'Sign in')]"));
		signin.click();
		
		
		driver.close();
		TakeScreenShot.captureScreenShot(driver, "shopping");
		
		
		
		

	}

}
