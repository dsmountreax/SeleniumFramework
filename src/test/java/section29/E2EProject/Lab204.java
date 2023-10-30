package section29.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Lab199;
import resources.Lab197;
//Validate Navigation Bar
public class Lab204 extends Lab197 {
	
	public static Logger log=LogManager.getLogger(Lab197.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void tearUp() throws IOException
	{
		driver=initializeDriver();
		driver.get("http://www.qaclickacademy.com");
	}
	
	@Test()
	public void basePageNavigation() throws IOException
	{
		Lab199 l=new Lab199(driver);
		Assert.assertTrue(l.getNavBar().isDisplayed());
		log.info("Navigation bar is displayed");
	}
	
	@AfterTest()
	public void teardown()
	{
		driver.close();
	}

}
