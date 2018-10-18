package com.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import org.junit.Assert.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepFileReport
{
	public WebDriver driver = null;
	static ExtentReports extent;
	ExtentTest test;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\WillPeters\\Reporting\\TeaWebsiteReport.html", true);
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address()
	{
		test = extent.startTest("Test initialised");
		driver.get("http://www.practiceselenium.com/welcome.html");
		test.log(LogStatus.INFO, "Tea website accessed");
		assertEquals(driver.getCurrentUrl(),"http://www.practiceselenium.com/welcome.html");
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page()
	{
	    HomepageX page1 = PageFactory.initElements(driver, HomepageX.class);
	    page1.moveToMenu(driver);
	    
	    String URL = driver.getCurrentUrl();
	    //report the test as a pass
	  	if(URL.equals("http://www.practiceselenium.com/menu.html"))
	  	{
	  		test.log(LogStatus.PASS, "Successfully taken to menu page");
	  	}
	  	else
	  	{
	  		test.log(LogStatus.FAIL, "Unsuccessful: navigation to menu page");
	  	}
	    extent.endTest(test);
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products()
	{
		MenupageX page2 = PageFactory.initElements(driver, MenupageX.class);
	    page2.checkOptions();
	    
	    String URL = driver.getCurrentUrl();
	    //report the test as a pass
	  	if(URL.equals("http://www.practiceselenium.com/menu.html"))
	  	{
	  		test.log(LogStatus.PASS, "Successful in browsing a list of the available products");
	  	}
	  	else
	  	{
	  		test.log(LogStatus.FAIL, "Unsuccessful: browsing the available products");
	  	}
	    extent.endTest(test);
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

	    String URL = driver.getCurrentUrl();
	    //report the test as a pass
	  	if(URL.equals("http://www.practiceselenium.com/check-out.html"))
	  	{
	  		test.log(LogStatus.PASS, "Successfully taken to checkout page");
	  	}
	  	else
	  	{
	  		test.log(LogStatus.FAIL, "Unsuccessful: navigation to checkout page");
	  	}
	    extent.endTest(test);
	    extent.flush();
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}
}