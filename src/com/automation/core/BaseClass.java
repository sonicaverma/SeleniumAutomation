package com.automation.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass
{
   private WebDriver driver;

   SeleniumCommands seleniumCommands;

   /**
    * This method is invoked before every test class.
    */
   @BeforeClass(alwaysRun = true)
   public void beforeClass()
   {
      driver = DriverFactory.getDriver();
      System.out.println("before class" + driver == null);
   }

   /**
    * This method is invoked before every test case.
    * 
    */
   @BeforeMethod(alwaysRun = true)
   public void setUp()
   {
      driver.manage().window().maximize();
      driver.get(DataFile.BASE_URL);
      SeleniumCommands.waitForElementToExist(By.xpath("//*[@href='http://www.myntra.com/?src=logo']"));
      // closing pop-up if it appears
      String dialog = "//*[@class='get-app-wrapper']";
      if (SeleniumCommands.findElementByXpath(dialog).isDisplayed())
         SeleniumCommands.findElementByXpath("//*[@class='close-wrapper shutdown-sprite close-banner']").click();
      new Validation("Online Shopping: Shop Dress, Shoes, Jeans, Bags Online in India ", SeleniumCommands.getPageTitle());
      testSetUp();
   }

   /**
    * This method can be overridden in test classes to setup the test related actions
    * 
    */
   @SuppressWarnings("unused")
   protected void testSetUp()
   {
   }

   /**
    * This method invokes after every test case execution It removes the driver and invokes logout
    * method
    */
   @AfterMethod(alwaysRun = true)
   public void tearDown()
   {
      closeWebDriver();
   }

   @AfterClass(alwaysRun = true)
   public void afetrClass()
   {
      driver.quit();
      driver = null;
   }

   protected void closeWebDriver()
   {
      driver.close();
   }

}
