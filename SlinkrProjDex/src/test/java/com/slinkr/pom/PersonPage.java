package com.slinkr.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonPage {

	public PersonPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='url']")
	private WebElement enterUrl;
	public WebElement getUrlLink()
	{
		return enterUrl;
	}

	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginPButton;
	public WebElement getPLoginButton()
	{
		return loginPButton;
	}
	
	@FindBy(id="tab")
	private WebElement tablePersonDetails;
	public WebElement getTablePersonDetails()
	{
		return tablePersonDetails;
	}
	
	@FindBy(xpath="//button[text()='Logout']")
	private WebElement logoutButton;
	public WebElement getLogoutButton()
	{
		return logoutButton;
	}
	
	@FindBy(xpath="//span[text()='sush']")
	private WebElement userLoggedinName;
	public WebElement getUserLoggedinName()
	{
		return userLoggedinName;
	}

	@FindBy(xpath="//h2[text()='Welcome to SLINKR , a tool to gather linkedin information']")
	private WebElement welcomeText;
	public WebElement getWelcomText()
	{
		return welcomeText;
	}
}
