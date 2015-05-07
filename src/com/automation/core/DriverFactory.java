package com.automation.core;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory
{
   Properties prop;

   String PropertyFilePath = "Locator.properties";

   private static DesiredCapabilities capabilities;

   private static WebDriver driver;

   private static ChromeDriverService service;

   public static WebDriver getDriver()
   {
      String BrowserName = DataFile.BROWSER;
      if (BrowserName == "firefox")
      {
         try
         {
            System.out.println("In firefox");

            capabilities = DesiredCapabilities.firefox();
            capabilities.setBrowserName("TestFirefox");
            FirefoxProfile profile = new FirefoxProfile();
            profile.setAcceptUntrustedCertificates(true);
            profile.setPreference("applicationCacheEnabled", false);
            profile.setPreference("webStorageEnabled", false);
            if(driver == null)
            {
               driver = new FirefoxDriver();
            }
            return driver;
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }

      }

      if (BrowserName == "chrome" && driver == null)
      {
         try
         {
            capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName("TestChrome");
            System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
            if(driver==null)
            {
               driver = new ChromeDriver();
            }
            return driver;
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
      return null;
   }
}
