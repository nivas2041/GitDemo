package SeleniumProjects.Project1;

import java.io.IOException;
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

public class ValidateTitle extends BrowserInvocation
{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeTest
	public void initialization() throws IOException
	{
		driver = initilizeBrowser();
		log.info("ValidateTitle:Browser got initialized");
		driver.get(prop.getProperty("url"));
		log.info("ValidateTitle:Reached to homepage");
		System.out.println("hare rama hare rama rama rama hare hare");
	}
	
	@Test
	public void browserInvocation() throws IOException
	{
		LandingPage l = new LandingPage(driver);
		String Actual_Title = l.getTitle().getText();
		Assert.assertEquals(Actual_Title, "FEATURED COURSE");
		log.info("ValidateTitle:Actual Title on page matched to Expected Title");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
}
	
	


