package com.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomepageX
{
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	private WebElement menuIcon;
	
	public WebDriver driver = null;
	
	public void moveToMenu(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(menuIcon).click().perform();
	}
}