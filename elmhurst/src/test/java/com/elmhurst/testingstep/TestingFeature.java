package com.elmhurst.testingstep;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestingFeature{
	static WebDriver driver;
	static TestingPageFactory tpf;
	static WebDriverWait wait;
	
	@Given("^user go to login page$")
	public void user_go_to_login_page() throws Throwable {
	    
	    
	    System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.phptravels.net/login");
		
		driver.manage().window().setSize(new Dimension(1920,1080));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		tpf= PageFactory.initElements(driver, TestingPageFactory.class);
		wait= new WebDriverWait(driver, 30);
		 
	}

	@When("^user enters a valid user name$")
	public void user_enters_a_valid_user_name() throws Throwable {	    

		wait.until(ExpectedConditions.visibilityOf(tpf.getUsername()));
		tpf.getUsername().sendKeys("user@phptravels.com");

	}

	@When("^user enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {	
		
		wait.until(ExpectedConditions.visibilityOf(tpf.getPassword()));
		tpf.getPassword().sendKeys("demouser");
	}

	@Then("^user click on the login button$")
	public void user_click_on_the_login_button() throws Throwable {	  
		
		wait.until(ExpectedConditions.elementToBeClickable(tpf.getLogin()));
		tpf.getLogin().click();
	}
	
	@Then("^user verify the visibility of Hi Demo User$")
	public void user_verify_the_visibility_of_Hi_Demo_User() throws Throwable {
	wait.until(ExpectedConditions.visibilityOf(tpf.getHidemouser()));
	}



	@When("^user click on log out button$")
	public void user_click_on_log_out_button() throws Throwable {	
		wait.until(ExpectedConditions.elementToBeClickable(tpf.getDemobtn()));
		tpf.getDemobtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(tpf.getLogoutbtn()));
		tpf.getLogoutbtn().click();
	}

	@Then("^user close the browser$")
	public void user_close_the_browser() throws Throwable {	  
	    driver.close();
	}
}