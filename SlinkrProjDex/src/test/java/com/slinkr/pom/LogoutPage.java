package com.slinkr.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	public LogoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[text()='Logout']")
	private WebElement logoutButton;
	public WebElement getLogoutButton()
	{
		return logoutButton;
	}

}
