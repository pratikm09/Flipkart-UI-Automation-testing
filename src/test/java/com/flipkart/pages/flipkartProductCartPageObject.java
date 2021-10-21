package com.flipkart.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.testcases.TC_flipkart;

public class flipkartProductCartPageObject {
	WebDriver driver;
	WebDriverWait wait;
	Logger logger = LogManager.getLogger(TC_flipkart.class);

	// Locators for product details in cart
	By prodSpecsFromCart = By.xpath("//div[@class='_6t1WkM _3HqJxg']/div[1]/div[1]/div[@class='_1YokD2 _3Mn1Gg col-12-12']/div[@class='_1AtVbE col-12-12']/div[1]/div[1]/div[1]");
	// div[@class='_6t1WkM _3HqJxg']/div[1]/div[1]/div[@class='_1YokD2 _3Mn1Gg
	// col-12-12']/div[@class='_1AtVbE col-12-12']
	By cartPageTitle = By.xpath("//div[starts-with(text(),'My Cart')]");
	By totalAmount = By.xpath("//div[@class='_3LxTgx']/div[1]/span[1]");
   // By totalAmount = By.xpath("//div[contains(text(),'Total Amount')]/../.././span");
	By removeButton = By.xpath("//div[normalize-space()='Remove']");
	public flipkartProductCartPageObject(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver,20);
	}

	// Methods use to get text
	public String getproductInfoFromCart() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(prodSpecsFromCart));
		String specs = "";
		List<WebElement> productspecsFromCart = driver.findElements(prodSpecsFromCart);
		specs = productspecsFromCart.get(0).getText();
		logger.info("Got the Specs details of Product");
		logger.info("####product specs from my cart: " + productspecsFromCart.get(0).getText());
		return specs;
	}
	
	public String getCartTitle()
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartPageTitle));
		String txt = driver.findElement(cartPageTitle).getText();
		logger.info("Got the title : "+cartPageTitle);
		return txt;
	}
	
	public boolean compareSpecs(String specsFromProductCatalogPage, String specsFromMyCart)
	{
		String specsInCart[];
		String specsOnCatalogPage[];
		specsInCart = specsFromMyCart.split("\n");
		specsOnCatalogPage = specsFromProductCatalogPage.split("\n");
		logger.info("specsInCart[0] ==>"+specsInCart[0]);
		logger.info("specsOnCatalogPage[0] ==>"+specsOnCatalogPage[0]);
		if(specsInCart[0].equals(specsOnCatalogPage[0]))
		{
			logger.info("Specs are Matched..!");
			return true;
		}
		else
			return false;
	}
	
	public String getTotalAmount()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(totalAmount));
		return driver.findElement(totalAmount).getText();
	}
	
	public void clickRemoveButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(removeButton));
		driver.findElement(removeButton).click();
		logger.info("Clicked on Remove Button for product removal process");
	}
	
}
