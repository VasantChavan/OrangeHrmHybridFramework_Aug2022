package com.vtechsolutions.orangehrm.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.vtechsolutions.orangehrm.utility.ConfigDataProvider;
import com.vtechsolutions.orangehrm.utility.ConstantVariable;
import com.vtechsolutions.orangehrm.utility.ExcelDataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	
	public static ConfigDataProvider configDataProvider;
	public static ExcelDataProvider excelDataProvider;
	
	
	@BeforeSuite
	public void init()
	{
		configDataProvider = new ConfigDataProvider(ConstantVariable.configDataPath);
		excelDataProvider = new ExcelDataProvider(ConstantVariable.excelPath);
	}

	@BeforeMethod
	@Parameters({ "brname"})
	public void setUp(@Optional("Chrome") String browser) {
		if (browser.equals("Chrome")) {
			// System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			 System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("Opera")) {
			// System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		else {
			System.out.println("Browser set up  doesn't matched with required browser...");
		}

		driver.manage().window().maximize();
		driver.get(configDataProvider.getAppUrl());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void tearDown() {

		try {
			Thread.sleep(5000);
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
