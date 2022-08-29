package com.vtechsolutions.orangehrm.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// Repository

	@FindBy(xpath = "//input[@name='username' or @placeholder='Username']")
	WebElement txtUsername;

	@FindBy(xpath = "//input[@name='password' or @placeholder='Password']")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit' or text()='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//img[@src='/web/images/ohrm_branding.png?1658889551093']")
	WebElement imgLogo;
	
	

	public boolean verifyOrangeHHrmLogo()
	{
		try {
			return imgLogo.isDisplayed();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	public void setUsername(String username) {
		try {
			txtUsername.clear();
			txtUsername.sendKeys(username);
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	public void setPassword(String password) {
		try {
			txtPassword.clear();
			txtPassword.sendKeys(password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickOnLoginBtn() {
		try {
			btnLogin.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
