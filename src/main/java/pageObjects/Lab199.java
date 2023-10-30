package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//Landing Page
public class Lab199 {
	
	public WebDriver driver;
	//no se puede usar el FindBy porque no esta inicializado el driver 
	private By signIn=By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");
	private By button=By.xpath("//button[text()='NO THANKS']/following::div[1]");
	private By title=By.cssSelector(".text-center>h2");
	private By navbar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	private By header=By.cssSelector("div[class*='video-banner'] p");
	
	public Lab199(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public Lab200 getLogin()
	{
		driver.findElement(signIn).click();
		Lab200 lp=new Lab200(driver);
		return lp;
	}
	
	public WebElement getButton()
	{
		return driver.findElement(button);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavBar()
	{
		System.out.println("Tratando de identificar la barra de navegacion");
		return driver.findElement(navbar);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
	
}
