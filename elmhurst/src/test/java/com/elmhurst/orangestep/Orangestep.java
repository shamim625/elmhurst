package com.elmhurst.orangestep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Orangestep {
	static WebDriver driver;
	static WebDriverWait wait;
	
	@Given("^user go to login page of OrangeHRM$")
	public void user_go_to_login_page_of_OrangeHRM() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver= new ChromeDriver();
		wait= new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@When ("^user enters valid username$")
	public void user_enters_valid_username() throws Throwable{
		driver.findElement(By.xpath("//input[@name= 'txtUsername']")).sendKeys("Admin");
	}
	
	@When ("^user enters valid password$")
	public void user_enters_valid_password() throws Throwable{
		driver.findElement(By.xpath("//input[@name= 'txtPassword']")).sendKeys("admin123");
	}
	
	@Then ("^user click on the login button of OrangeHRM$")
	public void user_click_on_the_login_button_of_OrangeHRM() throws Throwable{
		driver.findElement(By.xpath("//input[@name= 'Submit']")).click();
	}
	
	@When ("^user click on the Welcome Admin$")
	public void user_click_on_the_Welcome_Admin() throws Throwable{
		WebElement welcomeAdmin = driver.findElement(By.xpath("//*[contains(text(), 'Welcome Admin')]"));
		welcomeAdmin.click();
	}
	
	@Then ("^user click on the logout button$")
	public void user_click_on_the_logout_button() throws Throwable{
		WebElement logoutbtn =driver.findElement(By.xpath("//*[contains(text(), 'Logout')]"));
		wait.until(ExpectedConditions.elementToBeClickable(logoutbtn));
		logoutbtn.click();
	}
	
	@Then ("^user close the browser of orangehrm$")
	public void user_close_the_browser_of_orangehrm() throws Throwable{
		driver.close();
	}
}
