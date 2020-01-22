package elmhurst;

import java.awt.Dimension;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewTours {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.findElement(By.name("userName")).sendKeys("user@phptravels.com");
		driver.findElement(By.name("password")).sendKeys("demouser");
		driver.findElement(By.name("login")).click();
		System.out.println(driver.getTitle());
		
		
	    WebElement radio1= driver.findElement(By.xpath("//input[@value='roundtrip']"));
	    WebElement radio2= driver.findElement(By.xpath("//input[@value='oneway']"));
	    radio2.click();
	    
	    Select passengers =new Select(driver.findElement(By.xpath("//select[@name='passCount']")));
	    passengers.selectByValue("3");
	    Select departure =new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
	    departure.selectByVisibleText("New York");
	    Select dmonth =new Select(driver.findElement(By.xpath("//select[@name='fromMonth']")));
	    dmonth.selectByVisibleText("September");
	    Select dday =new Select(driver.findElement(By.xpath("//select[@name='fromDay']")));
	    dday.selectByValue("6");
	    Select destination =new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
	    destination.selectByVisibleText("London");
	    Select rmonth =new Select(driver.findElement(By.xpath("//select[@name='toMonth']")));
	    rmonth.selectByVisibleText("September");
	    Select rday=new Select(driver.findElement(By.xpath("//select[@name='toDay']")));
	    rday.selectByValue("7");
	    
	    WebElement serviceclass = driver.findElement(By.xpath("//input[@value='First']"));
	    serviceclass.click();
	    Select airline =new Select(driver.findElement(By.xpath("//select[@name='airline']")));
	    airline.selectByVisibleText("Unified Airlines");
	    driver.findElement(By.xpath("//input[@name='findFlights']")).click();
		System.out.println(driver.getTitle());
		WebElement depart=driver.findElement(By.xpath("//input[@value='Pangea Airlines$362$274$9:17']"));
		depart.click();
		WebElement returnflight= driver.findElement(By.xpath("//input[@value='Pangea Airlines$632$282$16:37']"));
		returnflight.click();
		driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();
		WebElement name1= driver.findElement(By.xpath("//input[@name='passFirst0']"));
		name1.sendKeys("Shamim");
		WebElement last1 = driver.findElement(By.xpath("//input[@name='passLast0']"));
		last1.sendKeys("Ahmed");
		Select meal=new Select(driver.findElement(By.xpath("//select[@name='pass.0.meal']")));
		meal.selectByVisibleText("Muslim");
		Select card =new Select(driver.findElement(By.xpath("//select[@'creditCard']")));
		card.selectByVisibleText("Visa");
	

	}

}
