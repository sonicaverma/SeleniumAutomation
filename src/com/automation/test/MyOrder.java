package com.automation.test;

import org.testng.annotations.Test;
import com.automation.core.BaseClass;
import com.automation.page.PageFactory;

public class MyOrder extends BaseClass
{
   PageFactory pageFactory = new PageFactory();
   
   @Override
   protected void testSetUp()
   {
      pageFactory.login();
   }
   
   @Test
   public void myOrderPage()
   {
      pageFactory.getDashboardPage().gotToOrderPage().isOrderPageOpened().shoulBeTrue("My Order page is not displayed.");
   }

}
