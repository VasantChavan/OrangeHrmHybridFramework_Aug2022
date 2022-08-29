package com.vtechsolutions.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtechsolutions.orangehrm.page_object.LoginPage;
import com.vtechsolutions.orangehrm.testbase.TestBase;
import com.vtechsolutions.orangehrm.utility.ExcelDataProvider;

public class LoginTC_03 extends TestBase{
	
	
	@Test(dataProvider="getData")	
	public void verifylogin(String username, String password) {
		
		LoginPage login = new LoginPage(driver);
		login.setUsername(username);
		login.setPassword(password);
		
		login.clickOnLoginBtn();
		
		if (driver.getPageSource().contains("Dashboard")) {
			Assert.assertTrue(true);
			System.out.println("Login success !!!");
		} 
		else if(driver.getPageSource().contains("Invalid credentials")) {
			Assert.assertTrue(true);
			System.out.println("Entered Invalid credentials Login should fail!!!");
		}
		else {
			Assert.assertTrue(false);
			System.out.println("Login Success !!!");
		}
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = ExcelDataProvider.getExcelData("Login1");
		return data;
	}

}
