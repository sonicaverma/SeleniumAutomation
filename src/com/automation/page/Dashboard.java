package com.automation.page;

import org.openqa.selenium.By;

import com.automation.core.SeleniumCommands;
import com.automation.core.Validation;

public class Dashboard
{
      
   private Dashboard dashboard;
   
   public Dashboard gotToOrderPage()
   {
      SeleniumCommands.waitForElementToExist(By.xpath("//*[@href='/my/orders']"));
      SeleniumCommands.findElementByXpath("//*[@href='/my/orders']").click();
      SeleniumCommands.waitForElementToExist(By.xpath("//*[@class='page-name']"));
      return this;
   }
   
   public Validation isOrderPageOpened()
   {
      return new Validation(SeleniumCommands.findElementByXpath("//*[@class='page-name']").getText().equalsIgnoreCase("My Orders"));
   }
   

}
