package elmhurst;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]")).click();
		driver.findElement(By.name("email")).sendKeys("ahmedshamim725@yahoo.com");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.findElement(By.name("password")).sendKeys("Tasfia68");
		driver.findElement(By.id("signInSubmit")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();
		driver.findElement(By.id("nav-cart")).click();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("winter hat");
		driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
		
		driver.findElement(By.id("nav-hamburger-menu")).click();
		driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[35]/li[47]/a")).click();
		//System.out.println(driver.getTitle());
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		//driver.findElement(By.id("nav-item-signOut")).click();

	}

}
