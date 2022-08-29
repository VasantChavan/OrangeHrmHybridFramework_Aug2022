package com.vtechsolutions.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtechsolutions.orangehrm.page_object.LoginPage;
import com.vtechsolutions.orangehrm.testbase.TestBase;
import com.vtechsolutions.orangehrm.utility.ExcelDataProvider;

public class LoginTC_02 extends TestBase{
	
	
	LoginPage lp;
	
	@Test
	public void loginTC_01() {
		
		lp = new LoginPage(driver);
		
//		lp.setUsername(ExcelDataProvider.getStringCellData(0, 1, 0));
//		lp.setPassword(ExcelDataProvider.getStringCellData(0, 1, 1));
		
		lp.setUsername(ExcelDataProvider.getStringCellData("Login", 1, 0));
		lp.setPassword(ExcelDataProvider.getStringCellData("Login", 1, 1));

		lp.clickOnLoginBtn();

		if (driver.getPageSource().contains("Dashboard")) {
			Assert.assertTrue(true);
			System.out.println("Login success !!!");
		} else {
			Assert.assertTrue(false);
			System.out.println("Login failed !!!");
		}

	}

}
