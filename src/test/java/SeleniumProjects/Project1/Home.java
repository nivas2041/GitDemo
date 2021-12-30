package SeleniumProjects.Project1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.BrowserInvocation;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class Home extends BrowserInvocation{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BrowserInvocation.class.getName());

	@BeforeTest
	public void initialization() throws IOException
	{
		driver = initilizeBrowser();
		log.info("Home : driver is initialized");
		
	}
	
	@Test(dataProvider="getData")
	public void browserInvocation(String Username,String Password) throws IOException
	{
		driver.get(prop.getProperty("url"));
		log.info("Home : Navigated to homepage");
		
		LandingPage l = new LandingPage(driver);
		l.getSignInPage().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getUserName().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getLogin().click();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object data[][] = new Object[2][2];
		
		data[0][0] = "non_restricted_user";
		data[0][1] = "pswrd1";
		
		
		data[1][0] = "restricted_user";
		data[1][1] = "pswrd2";
		
		return data;
		
		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
