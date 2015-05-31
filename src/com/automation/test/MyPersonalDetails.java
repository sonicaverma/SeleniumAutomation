package com.automation.test;

import org.testng.annotations.Test;
import com.automation.core.BaseClass;
import com.automation.page.PageFactory;

public class MyPersonalDetails extends BaseClass
{
   PageFactory pageFactory = new PageFactory();
   
   @Override
   protected void testSetUp()
   {
      pageFactory.login();
   }
   
   @Test
   public void myPersonalDetailsPage()
   {
      pageFactory.getPersonalDetailsPage().gotToPersonalDetailsPage().isPersonalDetailsPageOpened().shouldBeEqual("Personal Details page not open");
   }
   
   @Test
   public void testFirstName()
   {
      pageFactory.getPersonalDetailsPage().gotToPersonalDetailsPage().isFirstNameAvailable().shouldBeEqual("First Name not available");
   }
   @Test
   public void testLastName()
   {
      pageFactory.getPersonalDetailsPage().gotToPersonalDetailsPage().isLastNameAvailable().shouldBeEqual("Last Name not available");
   }

   @Test
   public void testEmail()
   {
      pageFactory.getPersonalDetailsPage().gotToPersonalDetailsPage().isEmailAvailable().shouldBeEqual("Email not available");
   }

   @Test
   public void testDateOfBirth()
   {
      pageFactory.getPersonalDetailsPage().gotToPersonalDetailsPage().isDOBAvailable().shouldBeEqual("Date of Birth not available");
   }

   @Test
   public void testGender()
   {
      pageFactory.getPersonalDetailsPage().gotToPersonalDetailsPage().isGenderAvailable().shouldBeEqual("Gender not available");
   }

   @Test
   public void testMobile()
   {
      pageFactory.getPersonalDetailsPage().gotToPersonalDetailsPage().isMobileAvailable().shouldBeEqual("Mobile Number not available");
   }

   @Test
   public void testEditProfile()
   {
      pageFactory.getPersonalDetailsPage().gotToPersonalDetailsPage().isEditProfileAvailable().shouldBeEqual("Edit Profile link not available");
   }
   
   @Test
   public void testChangePassword()
   {
      pageFactory.getPersonalDetailsPage().gotToPersonalDetailsPage().isChangePasswordAvailable().shouldBeEqual("Change Password link not available");
   }
   
  
}
