package com.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CheckoutPageX {

	@FindBy(xpath = "//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]/span")
	private WebElement checkOut;
	
	public void moveToCheckout(WebDriver driver)
	{
	Actions action = new Actions(driver);
	action.moveToElement(checkOut).click().perform();
	}	
}