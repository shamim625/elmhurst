package com.elmhurst.testingstep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TestingPageFactory {
	
	WebDriver driver;
	
	public TestingPageFactory(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.NAME, using= "username")
	private WebElement username;
	
	@FindBy(how=How.NAME, using= "password")
	private WebElement password;
	
	@FindBy(how=How.XPATH, using= "//button[@type='submit']")
	private WebElement login;
	
	@FindBy(how=How.XPATH, using="//*[contains(text(), 'Hi, Demo User')]")
	private WebElement hidemouser;
	
	@FindBy(how=How.XPATH, using= "(//a[@id='dropdownCurrency'])[2]")
	private WebElement demobtn;
	
	@FindBy(how=How.XPATH, using= "//*[contains(text(), 'Logout')]")
	private WebElement logoutbtn;
	
	
	
	

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsername() {
		return username;
	}

	public void setUsername(WebElement username) {
		this.username = username;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getLogin() {
		return login;
	}

	public void setLogin(WebElement login) {
		this.login = login;
	}

	public WebElement getHidemouser() {
		return hidemouser;
	}

	public void setHidemouser(WebElement hidemouser) {
		this.hidemouser = hidemouser;
	}

	public WebElement getDemobtn() {
		return demobtn;
	}

	public void setDemobtn(WebElement demobtn) {
		this.demobtn = demobtn;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}

	public void setLogoutbtn(WebElement logoutbtn) {
		this.logoutbtn = logoutbtn;
	}

	
	
	
	
	
	
	
	
	
}
