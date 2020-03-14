package Codes;

import java.util.concurrent.TimeUnit;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhpTravels {
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	
	public static void main(String[] args) throws InterruptedException { 
		
		 System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		 
		 driver = new ChromeDriver();
		 
		 driver.get("https://www.phptravels.net/login");
		
		System.out.println(driver.getTitle());
		driver.manage().window().setSize(new Dimension(1920,1080));
		 driver.manage().window().maximize();
		 //driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		 driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
		 driver.findElement(By.name("password")).sendKeys("demouser");
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 
		 wait= new WebDriverWait(driver, 30);
	
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Hi, Demo User')]")));
		 
		 WebElement dropDown = driver.findElement(By.xpath("(//a[@id='dropdownCurrency'])[2]"));
		 wait.until(ExpectedConditions.elementToBeClickable(dropDown));
		 dropDown.click();
		 
		 WebElement logout = driver.findElement(By.xpath("//*[contains(text(), 'Logout')]"));
		 
		 wait.until(ExpectedConditions.elementToBeClickable(logout));
		 
		 logout.click();
		 
		 driver.close();
		
	
	}
		
	}
		 
