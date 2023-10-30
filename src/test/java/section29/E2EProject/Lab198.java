package section29.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Lab199;
import pageObjects.Lab200;
import pageObjects.Lab213;
import resources.Lab197;

public class Lab198 extends Lab197{
	
	public static Logger log=LogManager.getLogger(Lab197.class.getName());
	public WebDriver driver;
	
	/*Lab198()
	{
		super();
	}*/
	
	@BeforeTest
	public void tearUp() throws IOException
	{
		driver=initializeDriver();
		
	}
	
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String password,String text,boolean boton) throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		Lab199 l=new Lab199(driver);
		if(boton)
		{l.getButton().click();}
		
		Lab200 lp=l.getLogin();
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		log.info(text);
		lp.getCommit().click();
		Lab213 fp=lp.forgot();
		fp.getEmail().sendKeys("correofalso@123.com");
		fp.getInstructions().click();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][4];
		
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="contraseña";
		data[0][2]="Non restricted";
		data[0][3]=true;
		
		data[1][0]="restricteduser@qw.com";
		data[1][1]="contraseña 1";
		data[1][2]="Restricted";
		data[1][3]=false;
		
		return data;
	}
	
	
	@AfterTest()
	public void teardown()
	{
		driver.close();
	}
	

}
