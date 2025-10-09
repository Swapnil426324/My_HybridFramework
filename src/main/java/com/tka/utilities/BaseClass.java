package com.tka.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tka.pages.LoginPage;
import com.tka.pages.RegisterPage;

public class BaseClass {

	public static WebDriver driver;
	public LoginPage lp;
	public RegisterPage rp;
	
	@BeforeMethod
	public void setUp() {
		String brName = ReadProperty.readConfig("browser");
		
		if(brName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(brName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(brName.equals("ie")) {
			driver = new InternetExplorerDriver();
		}
		
		String url = ReadProperty.readConfig("url");
		driver.get(url);
		
		lp = new LoginPage(driver);
		rp = new RegisterPage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			//driver.quit();
		}
	}
}
