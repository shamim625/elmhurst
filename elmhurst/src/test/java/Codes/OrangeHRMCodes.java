package Codes;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class OrangeHRMCodes {
	static WebDriver driver;
	static WebDriverWait wait;
	static WebElement employee;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver= new ChromeDriver();
		wait= new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.xpath("//input[@name= 'txtUsername']")).sendKeys("Admin");		
		driver.findElement(By.xpath("//input[@name= 'txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@name= 'Submit']")).click();
		
		
		
		//driver.findElement(By.xpath("//a[@id='menu_leave_viewLeaveModule']/b")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu_leave_viewLeaveModule']/b")));
		WebElement leave= driver.findElement(By.xpath("//a[@id='menu_leave_viewLeaveModule']/b"));
		leave.click();
		String actual= driver.findElement(By.xpath("//*contains(text(), 'Linda Anderson')")).getText();
		System.out.println("this is actual message:"+actual);
		String expected= "Linda Anderson";

		
		//WebElement welcomeAdmin = driver.findElement(By.xpath("//*[contains(text(), 'Welcome Admin')]"));
		//wait.until(ExpectedConditions.elementToBeSelected(welcomeAdmin));
		//welcomeAdmin.click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='welcome-menu']")));
		
		
//		WebElement logoutbtn =driver.findElement(By.xpath("//*[contains(text(), 'Logout')]"));
//		wait.until(ExpectedConditions.elementToBeClickable(logoutbtn));
//		logoutbtn.click();
	
	    driver.close();
	}

	
}
