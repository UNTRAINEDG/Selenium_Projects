package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.baseTest;
import utilities.readDataFromExcel;

public class myFirstTestFrameWork extends baseTest
{
	 @Test(priority=1 , dataProvider = "exceldata" , dataProviderClass = readDataFromExcel.class)
     public static void loginTest (String username , String password) throws InterruptedException
     {
    	
		
		driver.manage().window().maximize();
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
 		
 		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click(); // locators-- properties
 		driver.findElement(By.xpath(loc.getProperty("email_field"))).sendKeys(username);
 		Thread.sleep(2000);
 		driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
 		driver.findElement(By.id(loc.getProperty("pwd_field"))).sendKeys(password);
 		Thread.sleep(2500);
 		driver.findElement(By.cssSelector(loc.getProperty("login_next_Button"))).click();
     }
	 
	 
	
}
