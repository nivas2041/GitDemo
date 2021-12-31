package SeleniumProjects.Project1;

import
 java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.BrowserInvocation;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class ValidateNavigationBar extends BrowserInvocation
{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(ValidateNavigationBar.class.getName());
	
	@BeforeTest
	public void initialization() throws IOException
	{
		driver = initilizeBrowser();
		log.info("ValidateNavigationBar : driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("ValidateNavigationBar:Reached to homepage");
		System.out.println("hare krishna hare krishna krishna krishna hare hare");
	}


	@Test
	public void browserInvocation() throws IOException
	{
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("ValidateNavigationBar : Navigation bar is dispalyed");
		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

	
}
	
	


