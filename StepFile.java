package com.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepFile
{
	public WebDriver driver = null;

	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address()
	{
		driver.get("http://www.practiceselenium.com/welcome.html");
		assertEquals(driver.getCurrentUrl(),"http://www.practiceselenium.com/welcome.html");
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page()
	{
	    HomepageX page1 = PageFactory.initElements(driver, HomepageX.class);
	    page1.moveToMenu(driver);
	    assertEquals(driver.getCurrentUrl(),"http://www.practiceselenium.com/menu.html");
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products()
	{
		MenupageX page2 = PageFactory.initElements(driver, MenupageX.class);
	    page2.checkOptions();
	    assertEquals(driver.getCurrentUrl(),"http://www.practiceselenium.com/menu.html");
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button()
	{
		HomepageX page1 = PageFactory.initElements(driver, HomepageX.class);
	    page1.moveToMenu(driver);
		CheckoutPageX page3 = PageFactory.initElements(driver, CheckoutPageX.class);
	    page3.moveToCheckout(driver);
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page()
	{
		HomepageX page1 = PageFactory.initElements(driver, HomepageX.class);
	    page1.moveToMenu(driver);
		CheckoutPageX page3 = PageFactory.initElements(driver, CheckoutPageX.class);
	    page3.moveToCheckout(driver);
	    assertEquals(driver.getCurrentUrl(),"http://www.practiceselenium.com/check-out.html");
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	
}