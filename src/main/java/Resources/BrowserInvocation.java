package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserInvocation {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initilizeBrowser() throws IOException
	{
		prop= new Properties();
		FileInputStream fis = new FileInputStream("D:\\Shrinivasulu\\eclipse-workspace\\Project1\\src\\main\\java\\Resources\\data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Shrinivasulu\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.geckodriver.driver", "D:\\Shrinivasulu\\Work\\chromedriver_win32\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.mozilla.driver", "D:\\Shrinivasulu\\Work\\chromedriver_win32\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public String getScreenShot(String testName, WebDriver driver ) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot) driver;
		File sourFilePath = ts.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+"\\Reports\\"+testName+".png";
		 FileUtils.copyFile(sourFilePath,new File(destinationPath));
		 return destinationPath;
	}


}
