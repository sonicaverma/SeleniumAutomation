package com.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.core.DataFile;
import com.automation.core.ReadProperty;
import com.automation.core.SeleniumCommands;

public class PageFactory
{

   private static HomePage homePage = new HomePage();
   
   private static Dashboard dashboardPage = new Dashboard();
   
   private static PersonalDetails personalDetailsPage = new PersonalDetails();
   
   private static PageFactory pageFactory;
   
   public static PageFactory getInstance(){
      if (PageFactory.pageFactory==null)
      {
         PageFactory.pageFactory=new PageFactory();
      }
      return PageFactory.pageFactory;
   }
   
   public String getHomePageOpened()
   {
      return SeleniumCommands.getPageTitle();
   }
    
   public void login()
   {
      //logging in
      SeleniumCommands.waitForElementToExist(By.id("LoginForm_email"));
      SeleniumCommands.findElementByXpath("//*[@id='LoginForm_email']").click();
      SeleniumCommands.findElementByXpath("//*[@id='LoginForm_email']").sendKeys(ReadProperty.getProperty("UID"));
      SeleniumCommands.findElementByXpath("//*[@id='LoginForm_password']").sendKeys(ReadProperty.getProperty("PWD"));
      SeleniumCommands.findElementByXpath("//*[@id='qa-login-button']").click();
      SeleniumCommands.waitForElementToBeDisplayed(By.xpath("//*[@id='qa-my-acc-link']"));
   }
   
   public Dashboard getDashboardPage()
   {
      SeleniumCommands.waitForElementToExist(By.xpath("//span[text()='My aCCOUNT']"));
      return dashboardPage;
   }
   
   public PersonalDetails getPersonalDetailsPage()
   {
      SeleniumCommands.waitForElementToExist(By.xpath("//span[text()='PERSONAL DETAILS']"));
      return personalDetailsPage;
   }
   
}
