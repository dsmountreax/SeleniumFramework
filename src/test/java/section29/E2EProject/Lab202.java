package section29.E2EProject;

import java.io.IOException;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.Lab199;
import resources.Lab197;
//Validate title
public class Lab202 extends Lab197{
	public static Logger Log=LogManager.getLogger(Lab197.class.getName());
	public WebDriver driver;
	Lab199 l;
	
	@BeforeTest
	public void tearUp() throws IOException
	{
		driver=initializeDriver();
		Log.info("Driver is initialized"); 
		driver.get("http://www.qaclickacademy.com");
		Log.info("Navidated to Home page");
	}
	
	@Test()
	public void basePageNavigation() throws IOException
	{
		l=new Lab199(driver);
		System.out.println(l.getTitle().getText());
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES1234");
		Log.info("Successfully validated Text message");
		Assert.assertTrue(l.getNavBar().isDisplayed());
		Log.info("Successfully validated Navbar");
	}
	
	
	@Test()
	public void validateHeader() throws IOException
	{
		System.out.println(l.getHeader().getText());
		Assert.assertEquals(l.getHeader().getText(),"Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		Log.info("Successfully validated header");
	}
	
	@AfterTest()
	public void teardown()
	{
		driver.close();
	}
	
}
