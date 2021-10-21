package com.flipkart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.flipkart.testcases.TC_flipkart;

public class flipkartLoginPageObject {
	WebDriver driver;
	WebDriverWait wait;
	Logger logger = LogManager.getLogger(TC_flipkart.class);
	
	// Locators for Flipkart Login page
	By email = By.cssSelector("input[class='_2IX_2- VJZDxU']");
	By password = By.cssSelector("input[type='password']");
	By loginButton = By.xpath("//div[@class='_1D1L_j']/button[@class='_2KpZ6l _2HKlqd _3AWRsL']");
	
	By errorTextForEmail = By.cssSelector("span._2YULOR");
	// constructor
	public flipkartLoginPageObject(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver,30);
	}

	// methods use to click buttons
	public void enterEmail(String emailId) {
		wait.until(ExpectedConditions.elementToBeClickable(email));
		driver.findElement(email).sendKeys(emailId);
		logger.info("Entered an email");
	}
	
	public void enterPassword(String password1)
	{
		wait.until(ExpectedConditions.elementToBeClickable(password));
		driver.findElement(password).sendKeys(password1);
		logger.info("Password has been entered..");
	}
	
	public void clickLogin()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		driver.findElement(loginButton).click();
		logger.info("Clicked on Login..");
	}
	
	public String getErrorMsgForInvalidEmail()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorTextForEmail));
		String txt = driver.findElement(errorTextForEmail).getText();
		logger.info("Got the error message for an Invalid Email Input\n: "+txt);
		return txt;
	}

}
