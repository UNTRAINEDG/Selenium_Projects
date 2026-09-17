package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class myFirstTest {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver(); // base
		
		driver.get("https://www.zoho.com"); // baseTest / properties file
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		driver.findElement(By.linkText("Sign In")).click(); // locators-- properties
		driver.findElement(By.xpath("//input[@id=\"login_id\"]")).sendKeys("javaLinux@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.id("password")).sendKeys("x");
		driver.findElement(By.cssSelector("[id=\"nextbtn\"]")).click();
	}

}
