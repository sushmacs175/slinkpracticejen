package com.slinkr.testscript;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.slinkr.genericutility.BaseClass;
import com.slinkr.pom.LoginPage;
import com.slinkr.pom.PersonPage;

public class PeopleExecute {

@Listeners(com.slinkr.genericutility.ListenerImp.class)
public class scrapePerson extends BaseClass{
	@Parameters({"browser"})
	@Test(groups="regression")
	public void OneEndToEndSlinkrPerson() throws IOException
	{
	
	LoginPage loginS=new LoginPage(driver);
	loginS.getUsernameTextField().sendKeys(fileUtils.getPropertyData("username"));
	loginS.getPasswordTextField().sendKeys(fileUtils.getPropertyData("password"));
	loginS.getLoginButton().submit();
	}
	
	@Test
	public void titleVerification() {
	String expectedTitle="Nav Bar";
	String actualTitle=driver.getTitle();
	AssertJUnit.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test
	public void sendPersonUrl() throws IOException {
	LoginPage loginS=new LoginPage(driver);
	loginS.getUsernameTextField().sendKeys(fileUtils.getPropertyData("username"));
	loginS.getPasswordTextField().sendKeys(fileUtils.getPropertyData("password"));
	loginS.getLoginButton().submit();
	PersonPage person=new PersonPage(driver);	
	person.getUrlLink().sendKeys(fileUtils.getPropertyData("personurl"));
	person.getPLoginButton().submit();
	}
	
	@Test
	public void personTableDetails() throws IOException
	{
		LoginPage loginS=new LoginPage(driver);
	loginS.getUsernameTextField().sendKeys(fileUtils.getPropertyData("username"));
	loginS.getPasswordTextField().sendKeys(fileUtils.getPropertyData("password"));
	loginS.getLoginButton().submit();
	PersonPage person=new PersonPage(driver);	
	person.getUrlLink().sendKeys(fileUtils.getPropertyData("personurl"));
	person.getPLoginButton().submit();
	String persontabText=person.getTablePersonDetails().getText();
	System.out.println(persontabText);
	Reporter.log(persontabText);
	String name=person.getUserLoggedinName().getText();
	Reporter.log("user name is " +name);
	}
	
	@Test
	public void logoutScreenshot() throws IOException
	{
	LoginPage loginS=new LoginPage(driver);
	loginS.getUsernameTextField().sendKeys(fileUtils.getPropertyData("username"));
	loginS.getPasswordTextField().sendKeys(fileUtils.getPropertyData("password"));
	loginS.getLoginButton().submit();
	PersonPage person=new PersonPage(driver);
	String timeStamp=LocalDateTime.now().toString().replace(':','-');
	File tempFile = person.getLogoutButton().getScreenshotAs(OutputType.FILE);
	File permFile=new File("./errorshots/"+timeStamp+"logout.png");
	FileUtils.copyFile(tempFile, permFile);
	}
	
	@Test
	public void welcomText() throws IOException
	{
		LoginPage loginS=new LoginPage(driver);
		loginS.getUsernameTextField().sendKeys(fileUtils.getPropertyData("username"));
		loginS.getPasswordTextField().sendKeys(fileUtils.getPropertyData("password"));
		loginS.getLoginButton().submit();
		PersonPage person=new PersonPage(driver);
		String welcomeText=person.getWelcomText().getText();
		Reporter.log(welcomeText);
	}
}
}