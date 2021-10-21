package com.flipkart.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.testcases.TC_flipkart;
import com.google.common.base.Function;

public class flipkartProductsSummaryPageObject {
	WebDriver driver;
	Wait<WebDriver> wait1;
	WebDriverWait wait;
	public Logger logger = LogManager.getLogger(TC_flipkart.class);
	// Locators for search section
	By searchTextBox = By.name("q");
	By searchButton = By.xpath("//button[@type='submit']//*[name()='svg']");
	//_34RNph

	// Locators for Filters
	By minPriceDropdown = By.xpath("//div[contains(@class,'_1YAKP4')]//select[contains(@class,'_2YxCDZ')]");
	By minPriceOptions = By.xpath("//div[contains(@class,'_1YAKP4')]//select[contains(@class,'_2YxCDZ')]/option]");
	By maxPriceDropdown = By.xpath("//div[contains(@class,'_3uDYxP')]//select[contains(@class,'_2YxCDZ')]");
	By maxPriceOptions = By.xpath("//div[contains(@class,'_3uDYxP')]//select[contains(@class,'_2YxCDZ')]/option");
	By availabilityDropdown = By.xpath("//div[contains(text(),'Availability')]");
	By availabilityOptions = By.xpath("//div[contains(@title,'Exclude Out of Stock')]");
	By brandDropdown = By.xpath("//div[contains(text(),'Brand')]");
	By brandOptions = By.xpath("//*[@class='_1KOcBL']/section[6]/div[2]/div[1]/div[contains(@class,'_4921Z t0pPfW')]");
	By offersDropdown = By.xpath("//div[contains(text(),'Offers')]");
	By offerOptions = By.xpath("//*[@class='_1KOcBL']/section[5]/div[2]/div[1]/div[contains(@class,'_4921Z t0pPfW')]");
	By ramDropdown = By.xpath("//div[contains(text(),'RAM')]");
	By ramOptions = By.xpath("//div[@class='_1KOcBL']/section[5]/div[2]/div[1]//div[contains(@class,'_4921Z t0pPfW')]");
	
	//Locators for product list
	By productList = By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div/div/div/div/a/div[2]/div[1]/div[1]");
	By productSpecs = By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div/div/div/div/a/div[2]/div[1]/div[3]");
	// Locators product details section
	By addToCartButton = By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
	
	// constructor
	public flipkartProductsSummaryPageObject(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver,70);
//		wait1 = new FluentWait<WebDriver>(driver)
//				.withTimeout(60, TimeUnit.SECONDS)
//				.pollingEvery(4, TimeUnit.SECONDS)
//				.ignoring(NoSuchElementException.class);
	}

	// methods use to perform click event and input operation
	public void enterSearchingText() {
	
		wait.until(ExpectedConditions.elementToBeClickable(searchTextBox));	
	    driver.findElement(searchTextBox).sendKeys("mobile");;
		logger.info("Entered Text into Search box");
	}

	public void clickSearchButton() {
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		driver.findElement(searchButton).click();
		logger.info("Clicked on search Button");

	}

	public void clickMinPriceDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(minPriceDropdown));
		driver.findElement(minPriceDropdown).click();
		logger.info("Clicked on minPrice dropdown");
	}

	public void selectMinPriceOption(int index) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(minPriceDropdown));
		WebElement minPrice = driver.findElement(minPriceDropdown);
		Select select = new Select(minPrice);
		List<WebElement> minPriceOptions = select.getOptions();
		if (index < minPriceOptions.size()) {
			minPriceOptions.get(index).click();
		} else {
			minPriceOptions.get(1).click();
		}
		logger.info("Min price has been selected");
	}

	public void clickMaxPriceDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(maxPriceDropdown));
		driver.findElement(maxPriceDropdown).click();
//		WebElement element =wait1.until(new Function<WebDriver, WebElement>() {
//			public WebElement apply(WebDriver driver) {
//			return driver.findElement(maxPriceDropdown);
//			}
//			});
//		boolean res = element.isDisplayed();
//		logger.info("is maxprice button displayed? : "+res);
//		element.click();
//		logger.info("clicked on max price dropdown");
		
	}

	public void selectMaxPriceOption(int index) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(maxPriceDropdown));
		WebElement maxPrice = driver.findElement(maxPriceDropdown);
		Select select = new Select(maxPrice);
		List<WebElement> maxPriceOptions = select.getOptions();
		if (index < maxPriceOptions.size()) {
			maxPriceOptions.get(index).click();
		} else {
			maxPriceOptions.get(1).click();
		}
		logger.info("Max price has been selected");
	}

	public void clickRamDropdown() {
		driver.findElement(ramDropdown).click();
		logger.info("clicked on Ram dropdown");
	}

	public void selectRamOptions(int index) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ramOptions));
		 List<WebElement> ramOptionList = driver.findElements(ramOptions);
		 System.out.println("ramOptionList : ## "+ramOptionList);
					for (int i = index; i < ramOptionList.size(); i++) {
						if(ramOptionList.get(i).isSelected()==false)
						{
							ramOptionList.get(i).click();
							break;
						}
						else {continue;}
					}
		logger.info("Ram Option has been selected");
	}
	
	public void clickAvailability()
	{
		wait.until(ExpectedConditions.elementToBeClickable(availabilityDropdown));
		driver.findElement(availabilityDropdown).click();
		logger.info("Clicked on Availability dropdown");
	}
	
	public void selectProductAvailabilityOptions()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(availabilityOptions));
		driver.findElement(availabilityOptions).click();
		logger.info("Availability Option has been selected");
	}
	
	public void selectBrandOptions(int index) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(brandOptions));
		 List<WebElement> brandOptionList = driver.findElements(brandOptions);
		 //System.out.println("brandOptionList : ## "+brandOptionList);
					for (int i = index; i < brandOptionList.size(); i++) {
						if(brandOptionList.get(i).isSelected()==false)
						{
							brandOptionList.get(i).click();
							System.out.println("selected brand: "+brandOptionList.get(i).getText());
							break;
						}
						else {continue;}
					}
		logger.info("Product Brand has been selected..");
	}
	
	// method uses to select product
	public String selectProduct(int index)
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productList));
		String specs = "";
		List<WebElement> prodList = driver.findElements(productList);
		System.out.println("\n######"+prodList.size()+"\n");
			if(index < prodList.size())
			{
				specs = prodList.get(index).getText()+"\n"+getProductSpecs(index);
				prodList.get(index).click();
				logger.info("Product has been selected..");
				//logger.info("####selected product: "+prodList.get(index).getText());
			}
			return specs;	
	}
	
	public String getProductSpecs(int index)
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productSpecs));
		String specs="";
		List<WebElement> prodspecs = driver.findElements(productSpecs);
		//System.out.println("\n######"+prodspecs.size()+"\n");
		if(index < prodspecs.size())
		{
		    specs = prodspecs.get(index).getText();
		    logger.info("Got the Specs details of Product");
		//	System.out.println("####selected product: "+prodspecs.get(index).getText());
			//System.out.println("### product attributes"+ prodList.get(index));	
		}
		return specs;
		
	}
	
	public void addProductIntoCart()
	{
		String parent=driver.getWindowHandle();
		System.out.println("Value of Parent: "+parent);
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
		String child_window=I1.next();
		if(!parent.equals(child_window))
		{
		  driver.switchTo().window(child_window);	
		  break;
		}
	 }	
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
		driver.findElement(addToCartButton).click();
		logger.info("Product has been added into the cart...");
	}
	
}












