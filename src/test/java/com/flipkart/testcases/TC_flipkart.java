package com.flipkart.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.flipkart.pages.flipkartLoginPageObject;
import com.flipkart.pages.flipkartProductCartPageObject;
import com.flipkart.pages.flipkartProductsSummaryPageObject;

public class TC_flipkart extends Base {

	@Test(description="Verify an entire flow of add to cart process")
	public void verifyFlpkrtLogin() throws InterruptedException
	{
		flipkartProductsSummaryPageObject prodPageObj = new flipkartProductsSummaryPageObject(driver);
		flipkartLoginPageObject obj = new flipkartLoginPageObject(driver);
		flipkartProductCartPageObject cartPageObj = new flipkartProductCartPageObject(driver);
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, prop.getProperty("baseUrl"));
		obj.enterEmail(prop.getProperty("emailId"));
		obj.enterPassword(prop.getProperty("password"));
		obj.clickLogin();
		Thread.sleep(1000);	
		prodPageObj.enterSearchingText();
		prodPageObj.clickSearchButton();
	 	Thread.sleep(2000);
		prodPageObj.clickMinPriceDropdown();
		prodPageObj.selectMinPriceOption(3);
		Thread.sleep(2000);	
		prodPageObj.clickMaxPriceDropdown();
		prodPageObj.selectMaxPriceOption(4);
		js.executeScript("window.scrollBy(0,400)");
		prodPageObj.selectRamOptions(2);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);	
		prodPageObj.clickAvailability();
		prodPageObj.selectProductAvailabilityOptions();
		Thread.sleep(2000);	
		js.executeScript("window.scrollBy(0,500)");
		prodPageObj.selectBrandOptions(1);
		Thread.sleep(2000);	
		String specs = prodPageObj.selectProduct(3);
		System.out.println("##Specifications From Product catalog page:\n "+specs);
		Thread.sleep(3000);
		prodPageObj.addProductIntoCart();
		Thread.sleep(2000);
		String productDetailsFromMyCart = cartPageObj.getproductInfoFromCart();
		System.out.println("\n##Product Details From MyCart\n"+productDetailsFromMyCart);
		String title = cartPageObj.getCartTitle();
		System.out.println("##Cart Page Title ==> "+title);
		String amt = cartPageObj.getTotalAmount();
		prodPageObj.logger.info("Amt=  "+amt);
		//cartPageObj.clickRemoveButton();
		boolean res = cartPageObj.compareSpecs(specs,productDetailsFromMyCart);
		Assert.assertTrue(res);
	}
	
}
