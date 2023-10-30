package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Login Page
public class Lab200 {
	
	public WebDriver driver;
	//no se puede usar el FindBy porque no esta inicializado el driver
	By email=By.name("email");
	By password=By.name(" password");
	By commit=By.name("commit");
	By forgot=By.cssSelector("[href*='password/new']");
	
	public Lab200(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public Lab213 forgot()
	{
		driver.findElement(forgot).click();
		Lab213 fp=new Lab213(driver);
		return fp;
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getCommit()
	{
		return driver.findElement(commit);
	}

}
