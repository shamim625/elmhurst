package elmhurst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Kamrul {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("ahmedshamim725@yahoo.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Abdullah@627");
		driver.findElement(By.xpath("//*[@id=\"u_0_2\"]")).click();

	}

}
