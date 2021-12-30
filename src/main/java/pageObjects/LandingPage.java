package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage
{
	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By Sign_IN = By.cssSelector("a[href*='sign_in']");
	By Actual_Text = By.cssSelector(".text-center>h2");
	By Navigation_Bar = By.cssSelector("ul.nav.navbar-nav.navbar-right");
	
	public WebElement getSignInPage()
	{
		return driver.findElement(Sign_IN);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(Navigation_Bar);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(Actual_Text);
	}
}
