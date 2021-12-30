package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage
{
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By Username = By.cssSelector("[id='user_email']");
	By Password = By.cssSelector("[type='password']");
	By lgn_btn = By.cssSelector("[value='Log In']");
	
			
	
	public WebElement getUserName()
	{
		return driver.findElement(Username);
	}
	public WebElement getPassword()
	{
		return driver.findElement(Password);
	}
	public WebElement getLogin()
	{
		return driver.findElement(lgn_btn);
	}

}
