package com.automation.test;

	import static org.junit.Assert.*;
	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class MyPoints {

		WebDriver driver = new FirefoxDriver();
		String active = "0";
		String pending = "0";
		
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
			
			//Navigating to My Points page
			
			waitForElementToBeClickable(driver, By.xpath("//span[text()='My Myntra']"), 10);
	        driver.findElement(By.xpath("//*[text()='My Myntra']")).click();		
			driver.findElement(By.xpath("//*[text()='My Points']")).click();
			
			//Getting points
			String activePoints = driver.findElement(By.xpath("//span[@class='active-points']")).getText();
			String pendingPoints = driver.findElement(By.xpath("//div[@class='points-wrapper']/div[2]//*[@class='count']")).getText();
			
			System.out.println(activePoints+", "+pendingPoints);
			
			assertTrue("Active points didn't match", activePoints.equalsIgnoreCase(active));
			assertTrue("Pending points didn't match", pendingPoints.equalsIgnoreCase(pending));
			
			
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
