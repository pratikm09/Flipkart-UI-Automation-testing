package com.flipkart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pages.flipkartLoginPageObject;

public class TC_flipkartLogin extends Base {

	@Test
	public void verifyFlipkartLoginWithInvalidData()
	{
		flipkartLoginPageObject obj = new flipkartLoginPageObject(driver);
		String email, passwd;
		email = "qwerewr12314";
		passwd = "Demotest@9999";
		obj.enterEmail(email);
		obj.enterPassword(passwd);
		obj.clickLogin();	
		//obj.getErrorMsgForInvalidEmail();
		Assert.assertEquals(obj.getErrorMsgForInvalidEmail(),"Please enter valid Email ID/Mobile number");

	}
	
}
