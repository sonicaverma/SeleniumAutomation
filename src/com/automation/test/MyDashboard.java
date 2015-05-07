package com.automation.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.core.BaseClass;
import com.automation.core.DataFile;
import com.automation.core.DriverFactory;

public class MyDashboard extends BaseClass {

	WebDriver driver = DriverFactory.getDriver();
	String defaddress = "Capgemini India Pvt. Ltd. Crescent 2, Prestige Shantiniketan, Sadaramanagala Village, Whitefield Main Road, Bangalore, Karnataka, India\n"
+"Whitefield\n"
+"Bangalore-560048\n"
+"Karnataka\n"
+"Mobile: 8884404710";
	
	@Before
	public void login() {
				 
		 driver.get("http://www.myntra.com");
		 driver.manage().window().maximize();
		 
		 String popup = "/html/body/div[1]/div[1]/div[1]/div[10]/div[1]/span";
		 
		 //closing pop-up if it appears
		 if(driver.findElement(By.xpath(popup)).isDisplayed())
			 driver.findElement(By.xpath(popup)).click();
		 
		 //logging in
		 driver.findElement(By.xpath("//div[@class='login']/a")).click();
		 
		 WebElement username = driver.findElement(By.xpath("//form[@class='signin']//div[@class='email']/input"));
		 username.sendKeys("sanjana.x.rawat@gmail.com");
		 
		 WebElement password = driver.findElement(By.xpath("//form[@class='signin']//div[@class='password']/input"));
		 password.sendKeys("outrageous");
		 
		 driver.findElement(By.xpath("//button[@name='signin']")).click();
	}
	
	@Test
	public void myorders()
	{
		String address ="";
		
		//Navigating to My Address page
		waitForElementToBeClickable(driver, By.xpath("//span[text()='My Myntra']"), 10);
        driver.findElement(By.xpath("//*[text()='My Myntra']")).click();		
		driver.findElement(By.xpath("//div[@class='address']//a")).click();
		
		//Getting default address details
		int size = driver.findElements(By.xpath("//*[@class='address-description']")).size();
		String builtString="//div[@class='addresses']/div[";

		for(int index=1;index<=size;index++)
		{
			WebElement aux =driver.findElement(By.className("page-name"));

		try
		{
		   aux= driver.findElement(By.xpath(builtString+index+"]"));
		   
		   if(aux.findElement(By.className("default-text")).isDisplayed())
			   	address = aux.findElement(By.className("address-content")).getText();
		   
		}
		catch(NoSuchElementException e){
			e.getMessage();
		}
		catch(Exception e){
			e.getMessage();
		}
		
		}
		assertEquals("Address didn't match",defaddress,address);
	}

	@After
	public void logout()
	{
		driver.close();
	}

	public static void waitForElementToBeClickable(WebDriver driver, final By locator, int DEFAULT_WAIT_IN_SECONDS)
	   {
	      System.out.println("waiting");
	      WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_IN_SECONDS);
	      wait.until(ExpectedConditions.elementToBeClickable(locator));
	   }
}
