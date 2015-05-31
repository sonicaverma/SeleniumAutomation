package com.automation.page;

import org.openqa.selenium.By;

import com.automation.core.SeleniumCommands;
import com.automation.core.Validation;

public class PersonalDetails
{
      
   private PersonalDetails dashboard;
   
   
  //Action Methods
   public PersonalDetails gotToPersonalDetailsPage()
   {
      SeleniumCommands.waitForElementToExist(By.linkText("PERSONAL DETAILS"));
      SeleniumCommands.findElementByLinkText("PERSONAL DETAILS").click();
      SeleniumCommands.waitForElementToExist(By.xpath("//li[@class='active']/a[text()='PERSONAL DETAILS']"));
      return this;
   }
   
   public String getFirstName()
   {
	   return SeleniumCommands.findElementByXpath("//label[text()='First Name']/following-sibling::span").getText();
   }
   
   
   //Validation Methods
   public Validation isPersonalDetailsPageOpened()
   {
      return new Validation(SeleniumCommands.findElementByXpath("//li[@class='active']/a").getText(),"PERSONAL DETAILS");
   }
   
   public Validation isFirstNameAvailable()
   {
	   return new Validation(SeleniumCommands.findElementByXpath("//*[text()='First Name']").getText(), "First Name");
   }
   
   public Validation isLastNameAvailable()
   {
	   return new Validation(SeleniumCommands.findElementByXpath("//*[text()='Last Name']").getText(), "Last Name");
   }
   
   public Validation isEmailAvailable()
   {
	   return new Validation(SeleniumCommands.findElementByXpath("//*[text()='Email']").getText(), "Email");
   }
   
   public Validation isDOBAvailable()
   {
	   return new Validation(SeleniumCommands.findElementByXpath("//*[text()='Date of Birth']").getText(), "Date of Birth");
   }
   
   public Validation isGenderAvailable()
   {
	   return new Validation(SeleniumCommands.findElementByXpath("//*[text()='Gender']").getText(), "Gender");
   }
   
   public Validation isMobileAvailable()
   {
	   return new Validation(SeleniumCommands.findElementByXpath("//*[text()='Mobile no.']").getText(), "Mobile no.");
   }
   
   public Validation isEditProfileAvailable()
   {
	   return new Validation(SeleniumCommands.findElementByXpath("//*[text()='EDIT PROFILE']").getText(), "EDIT PROFILE");
   }
   
   public Validation isChangePasswordAvailable()
   {
	   return new Validation(SeleniumCommands.findElementByXpath("//*[text()='CHANGE PASSWORD']").getText(), "CHANGE PASSWORD");
   }
   
   
   

}
