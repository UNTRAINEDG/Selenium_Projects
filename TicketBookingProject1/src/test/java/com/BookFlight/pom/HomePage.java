package com.BookFlight.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage 
{
    WebDriver driver;
    
    public HomePage(WebDriver driver)
    {
    	this.driver = driver;
    }
    
    By closePopup = By.xpath("//span[@data-cy=\"closeModal\"]");
    By roundTripButton = By.xpath("//li[@data-cy='roundTrip']");
    By sourceCity = By.id("fromCity");
    By sourceSearchBox = By.xpath("//input[@placeholder='From']");
    By destinationCity = By.xpath("//input[@id='toCity']");
    By destinationSearchBox = By.xpath("//input[@aria-controls='react-autowhatever-1']");
    By searchButton = By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']");
    By puneCity = By.xpath("(//p[@class=\"revampedAirportName\"])[1]");
    
    // Action Methods
    
    public void clickClosePopUp() throws InterruptedException
    {
    	driver.findElement(closePopup).click();
    	Thread.sleep(2000);
    }
    
    
    public void clickRoundTripButton() throws InterruptedException
    {
    	driver.findElement(roundTripButton).click();
    	Thread.sleep(2000);
    }
    
    public void sourceCity(String fromCity) throws InterruptedException
    {
    	driver.findElement(sourceCity).click();
    	Thread.sleep(2000);
    	driver.findElement(sourceSearchBox).sendKeys(fromCity); // we will pass this from outside
    	Thread.sleep(2000);
    	// as we are doing it dynamically so we cannot pass name directly of the city
    	// so we will pass it like this " + city name + "
    	//driver.findElement(By.xpath("//span[text()='"+fromCity+"']")).click();
    }
    
    public void clickSourceCity(String sourceCity1)
    {
    	
    	WebElement a = driver.findElement(By.xpath("//p[text()='"+sourceCity1+"']"));
    	a.click();
    }
    
    public void destinationCityM1(String toCity) throws InterruptedException
    {
    	driver.findElement(destinationCity).click();
    	Thread.sleep(2000);
    	driver.findElement(destinationSearchBox).sendKeys(toCity); // we will pass this from outside
    	Thread.sleep(2000);
    	// as we are doing it dynamically so we cannot pass name directly of the city
    	// so we will pass it like this " + city name + "
    	driver.findElement(By.xpath("//p[text()='"+toCity+"']")).click();
    	
    }
    
    public void selectDepartureDate() throws InterruptedException
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(500,500)");
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//div[@aria-label='Fri Aug 28 2026']")).click();
    }
    
    public void selectReturnDate()
    {
    	driver.findElement(By.xpath("(//div[@aria-label='Sun Aug 30 2026'])[1]")).click();
    }
    
    public void clickSearchButton()
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(-100,-100)");
    	driver.findElement(searchButton).click();
    }
    
    
    
}
