package com.slinkr.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement usernameTextField;
	public WebElement getUsernameTextField()
	{
		return usernameTextField;
	}
	
	@FindBy(name="password")
	private WebElement passwordTextField;
	public WebElement getPasswordTextField()
	{
		return passwordTextField;
	}
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginButton;
	public WebElement getLoginButton()
	{
		return loginButton;
	}
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginColor;
	public WebElement getLoginColorButton()
	{
		return loginColor;
	}
	
	@FindBy(xpath="//span[@class='text-danger']")
	private WebElement loginErrorMsg;
	public WebElement getLoginErrorMsg()
	{
		return loginErrorMsg;
	}
}
