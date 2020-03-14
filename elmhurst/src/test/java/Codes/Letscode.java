package Codes;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import screenshot.TakeScreenShot;


public class Letscode {
	static WebDriver driver;
	static WebDriverWait wait;

	
	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();

		//Radio button example
		WebElement honda = driver.findElement(By.xpath("//*[@value='honda']"));
		honda.click();
		
		//Select class example
		Select carselect = new Select(driver.findElement(By.xpath("//*[@id='carselect']")));
		carselect.selectByValue("honda");
		
		//Multiple select example
		WebElement multiSelect= driver.findElement(By.xpath("//*[@id='multiple-select-example']"));
		Select multiple = new Select(multiSelect);
		multiple.selectByValue("apple");
		multiple.selectByValue("peach");
		
		//Checkbox
		WebElement hondacheck = driver.findElement(By.xpath("//*[@id='hondacheck']"));
		hondacheck.click();
		WebElement bmwcheck = driver.findElement(By.xpath("//*[@id='bmwcheck']"));
		bmwcheck.click();
		
		//Switch handle
		String window1 = driver.getWindowHandle();
//		System.out.println("first window:"+ windowhandle);
		
		WebElement openwindow = driver.findElement(By.xpath("//*[@id='openwindow']"));
		openwindow.click();
		
//		Set<String> windowhandles= driver.getWindowHandles();
//		System.out.println("old plus new window name:"+ windowhandles);
//		System.out.println("Window title before change:"+ driver.getTitle());
		
		for (String handle1: driver.getWindowHandles()) {
//			System.out.println("Changing window:+ handle1");
			
			driver.switchTo().window(handle1);
			driver.manage().window().maximize();
			Thread.sleep(1000);
		}
		
//		System.out.println("Title after change:"+ driver.getTitle());
		driver.close();
		driver.switchTo().window(window1);
		
		WebElement opentab= driver.findElement(By.xpath("//*[@id='opentab']"));
		opentab.click();
		
		ArrayList<String> tabs= new ArrayList<String> (driver.getWindowHandles());
		System.out.println("number of open tabs:"+tabs.size());
		driver.switchTo().window(tabs.get(tabs.size()-1));
		System.out.println("window title after change:"+ driver.getTitle());
		driver.close();
		driver.switchTo().window(tabs.get(0));
		
		//Alert code
		
		WebElement alertname = driver.findElement(By.xpath("//*[@id='name']"));
		alertname.sendKeys("Shaamim");
		driver.findElement(By.xpath("//*[@id='alertbtn']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		WebElement confirmbtn = driver.findElement(By.xpath("//*[@id='confirmbtn']"));
		confirmbtn.click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
		// javascript scroll down
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		
		//Web table example
		WebElement webtable =driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
		System.out.println("Getting text from web table:"+webtable.getText());
		
		//element displayed
		WebElement display = driver.findElement(By.xpath("//*[@id='displayed-text']"));
		WebElement hide = driver.findElement(By.xpath("//*[@id='hide-textbox']"));
		WebElement show= driver.findElement(By.xpath("//*[@id='show-textbox']"));
		hide.click();
		
		if(display.isDisplayed()) {
			show.click();
		}
		else {
			System.out.println("The element is hidden");
		}
		
		
		//mouse hover
		js.executeScript("window.scrollBy(0, 1300)");
		Actions action= new Actions(driver);
		
		WebElement mousehover= driver.findElement(By.xpath("//*[@id='mousehover']"));
		WebElement reload = driver.findElement(By.xpath("//*[contains(text(),'Reload')]"));
		
		action.moveToElement(mousehover).perform();
		Thread.sleep(2000);
		reload.click();
		
		
		
		String Practice = driver.findElement(By.xpath("//*[contains(text(), 'Practice Page')]")).getText();
		Assert.assertTrue("Practice Page not showed", Practice.matches(Practice));
		
		//iFrame example
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 1400)");
		driver.switchTo().frame("courses-iframe");                                                                                 //Using Id
		
		WebElement findcourse = driver.findElement(By.xpath("//*[@id='search-courses']"));
		findcourse.sendKeys("selenium webdriver advanced");
		
		WebElement search = driver.findElement(By.xpath("//*[@id='search-course-button']"));
		search.click();
		
		TakeScreenShot.captureScreenShot(driver, "letscodebro");
		
		
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
