package elmhurst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PhpTravels {
	public static void main(String[] args) throws InterruptedException { 
		
		 System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		 
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("https://www.phptravels.net/login");
		 //boy.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(driver.getTitle());
		driver.manage().window().setSize(new Dimension(1920,1080));
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		 driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
		 driver.findElement(By.name("password")).sendKeys("demouser");
		driver.findElement(By.xpath("(//*[text()='Login'])[3]")).click();
		 driver.manage().window().maximize();
		 Thread.sleep(2);
		
		 
		 Select dropdown = new Select(driver.findElement(By.className("dropdown-menu-inner")));
		 dropdown.selectByIndex(3);
		 
		 
		 //JavascriptExecutor js= (JavascriptExecutor)driver;
		// js.executeScript("scrollBy(0, 1500)");
		 
		
		
//		WebElement submit=driver.findElement(By.xpath("//*[contains(@class,'btn btn-primary btn-lg btn-block loginbtn')]"));
//		Actions actions=new Actions(driver);
//	actions.moveToElement(submit).click().perform();
//		submit.click();
		
		
		 //Thread.sleep(3000);
	}
		
	}
		 
