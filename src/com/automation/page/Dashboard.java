package com.automation.page;

import org.openqa.selenium.By;

import com.automation.core.SeleniumCommands;
import com.automation.core.Validation;

public class Dashboard
{
      
   private Dashboard dashboard;
   
   public Dashboard gotToOrderPage()
   {
      SeleniumCommands.waitForElementToExist(By.linkText("ORDERS"));
      SeleniumCommands.findElementByLinkText("ORDERS").click();
      SeleniumCommands.waitForElementToExist(By.xpath("//li[@class='active']/a[text()='Orders']"));
      return this;
   }
   
   public Validation isOrderPageOpened()
   {
      return new Validation(SeleniumCommands.findElementByXpath("//li[@class='active']/a").getText(),"ORDERS");
   }
   

}
