package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Forgot Password
public class Lab213 {
	
	public WebDriver driver;
	//no se puede usar el FindBy porque no esta inicializado el driver
	By email=By.name("email");
	By password=By.name(" password");
	By instructions=By.name("commit");
	
	
	public Lab213(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getInstructions()
	{
		return driver.findElement(instructions);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}

}
