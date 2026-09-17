package com.BookFlight.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.BookFlight.pom.HomePage;

public class TestCasesBookFlight 
{
    WebDriver driver;
    
    @BeforeTest
    public void launchChromeBrowser() throws InterruptedException
    {
    	driver = new ChromeDriver();
    	driver.get("https://www.makemytrip.com/flights/?cmp=SEM|D|DF|B|Brand|Brand-BrandExact_DT|B_M_Makemytrip_Search_Exact|Brand_Top_5_Exact|RSA|&ef_id=:G:s&msclkid=7e58c35671471f6cee7da9d95bcad50d");
    	Thread.sleep(2000);
    	driver.manage().window().maximize();
    	Thread.sleep(5000);
    }
    
    @Test
    public void searchFlightTickets() throws InterruptedException
    {
    	HomePage homepage = new HomePage(driver);
    	
    	//homepage.clickClosePopUp();
    	homepage.clickRoundTripButton();
    	homepage.sourceCity("Pune Airport");
    	homepage.clickSourceCity("Pune Airport");
    	homepage.destinationCityM1("Rajiv Gandhi International Airport");
    	homepage.selectDepartureDate();
    	homepage.selectReturnDate();
    	homepage.clickSearchButton();
    }
    
    @AfterTest
    public void closeBrowser()
    {
    	//driver.close();
    }
}
