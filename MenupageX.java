package com.qa;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenupageX
{

	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]")
	private WebElement greenTea;
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]")
	private WebElement redTea;
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231735\"]")
	private WebElement oolongTea;
	
	public boolean checkOptions()
	{
		try
		{
			greenTea.getLocation();
			redTea.getLocation();
			oolongTea.getLocation();
			return true;
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e);
			return false;
		}
	}
}