package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class baseTest 
{
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	
	public static FileInputStream fis;
	public static FileInputStream fis1;
	
	// Here we are having After method and Before method
	
	@BeforeMethod
     public void setup() throws IOException, InterruptedException
     {
		System.out.println("The path is"+System.getProperty("user.dir")); 
		
    	if(driver == null)
    	{
    		FileInputStream fis = new FileInputStream("C:\\Users\\nitis\\eclipse-workspace\\TestAutomationFramework\\src\\test\\resources\\configfiles\\config.properties");
    		FileInputStream fis1 = new FileInputStream("C:\\Users\\nitis\\eclipse-workspace\\TestAutomationFramework\\src\\test\\resources\\configfiles\\locators.properties");
    		prop.load(fis);
    		loc.load(fis1);
    		
    	}
    	if(prop.getProperty("browser").equals("chrome"))
    	{
    		driver = new ChromeDriver();
    		driver.get(prop.getProperty("testUrl"));
    		System.out.println("This time chrome");
    	}
    	
    	else if(prop.getProperty("browser").equals("edge"))
    	{
    		driver = new EdgeDriver();
    		driver.get(prop.getProperty("testUrl"));
    		System.out.println("This time edge");
    	}
    	else
    	{
    		System.out.println("Please enter the right option Chrome or edge");
    	}
    	
    	
     }
	
     @AfterMethod
     public void teardown() throws InterruptedException
     {
    	 Thread.sleep(10000);
    	 driver.quit();
    	 System.out.println("Tear down Sucessfully");
     }
}
