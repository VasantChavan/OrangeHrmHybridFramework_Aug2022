package com.vtechsolutions.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtechsolutions.orangehrm.page_object.LoginPage;
import com.vtechsolutions.orangehrm.testbase.TestBase;

public class LoginTC_01 extends TestBase {

	LoginPage lp;

	@Test(priority = 2)
	public void verifyLoginPageTitleTC() {
		if (driver.getTitle().equals("OrangeHRM")) {
			Assert.assertTrue(true);
			System.out.println("Login page title is verified");
		} else {
			System.out.println("Login page title is not matcched with expected title");
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 1)
	public void verifyOrangeHrmLogoTC() {
		lp = new LoginPage(driver);

		if (lp.verifyOrangeHHrmLogo()) {
			Assert.assertTrue(true);
			System.out.println("Orange HRM Logo is displayed on login page");
		} else {
			System.out.println("Orange HRM Logo is not  displayed on login page");
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 4)
	public void loginTC_01() {

		lp = new LoginPage(driver);
		lp.setUsername(configDataProvider.getUserName());
		lp.setPassword(configDataProvider.getPassword());

		lp.clickOnLoginBtn();

		if (driver.getPageSource().contains("Dashboard")) {
			Assert.assertTrue(true);
			System.out.println("Login success !!!");
		} else {
			Assert.assertTrue(false);
			System.out.println("Login failed !!!");
		}

	}


//	@Test(priority = 3)
//	public void loginTC_01() {
//
//		lp.setUsername("Admin");
//		lp.setPassword("admin123");
//
//		lp.clickOnLoginBtn();
//
//		if (driver.getPageSource().contains("Dashboard")) {
//			Assert.assertTrue(true);
//			System.out.println("Login success !!!");
//		} else {
//			Assert.assertTrue(false);
//			System.out.println("Login failed !!!");
//		}
//
//	}

}
