package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


// Base File 
public class Lab197 {
	
	public WebDriver driver;
	public Properties prop=new Properties();
    
	
	public WebDriver initializeDriver() throws IOException
	{
		final String path=System.getProperty("user.dir");
		final String pathProperties="\\src\\main\\java\\resources\\data.properties";
		
		FileInputStream fis=new FileInputStream(path+pathProperties);
		prop.load(fis);
		//Lab216
		//mvn test _Dbrowser=chrome		
		//String browserName=prop.getProperty("browser"); // desactivar para jenkins
		String browserName=System.getProperty("browser"); //activar para jenkins
		System.out.println(browserName); //activar para jenkins
		//End Lab216
		
		if (browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Work\\chromedriver89\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("--headless");
			}
			driver=new ChromeDriver(options);
			
		}
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Work\\firefoxdriver\\geckodriver.exe");
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("headless");
			driver=new FirefoxDriver(options);
		}else
		{
			System.setProperty("webdriver.edge.driver", "D:\\Work\\edgedriver\\edge.exe");
			driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//fis.close();
		return driver;	
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
	
}
