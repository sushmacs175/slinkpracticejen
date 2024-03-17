package com.slinkr.genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseClass {

	public static WebDriver driver;

	public FileUtility fileUtils=new FileUtility();
	@BeforeTest(groups= {"regression","smoketest"})
	@Parameters("browser")
	public void executeBeforeClass(@Optional("chrome") String browser) throws IOException
	{
		
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
		   driver= new FirefoxDriver();	
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(fileUtils.getPropertyData("url"));
	}
	
	@AfterTest(groups= {"regression","smoketest"})
	@Parameters("browser")
	public void executeAfterClass()
	{
	driver.manage().window().minimize();
	driver.quit();
	}
	
}
