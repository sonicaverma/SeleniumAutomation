package com.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.core.SeleniumCommands;

public class PageFactory
{

   private static HomePage homePage = new HomePage();
   
   private static Dashboard dashboardPage = new Dashboard();
   
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
      SeleniumCommands.waitForElementToExist(By.xpath("//div[@class='login']/a"));
      SeleniumCommands.findElementByXpath("//div[@class='login']/a").click();
      SeleniumCommands.findElementByXpath("//form[@class='signin']//div[@class='email']/input").sendKeys("sanjana.x.rawat@gmail.com");
      SeleniumCommands.findElementByXpath("//form[@class='signin']//div[@class='password']/input").sendKeys("outrageous");
      SeleniumCommands.findElementByXpath("//button[@name='signin']").click();
      SeleniumCommands.waitForElementToDisappear(By.xpath("//*[@class='get-app-wrapper']"));
   }
   
   public Dashboard getDashboardPage()
   {
      SeleniumCommands.waitForElementToExist(By.xpath("//span[text()='My Myntra']"));
      SeleniumCommands.findElementByXpath("//*[text()='My Myntra']").click(); 
      return dashboardPage;
   }
   
}
