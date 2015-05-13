package com.automation.core;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class SeleniumCommands {

   static final int DEFAULT_WAIT_IN_SECONDS = 5;

   static WebDriver driver = DriverFactory.getDriver();

   public void clickByID(String locator) {

      driver.findElement(By.id(locator)).click();

   }

   public static void clickByName(String locator) {
      driver.findElement(By.name(locator));

   }
   
   public static void sendKeysByXpath(String wheelPickerXpath, String dataString) {
      waitForElementToExist(By.xpath(wheelPickerXpath));
      driver.findElement(By.xpath(wheelPickerXpath)).sendKeys(dataString);

   }

   public static void typeById(String locator, String textValue) {

      driver.findElement(By.id(locator)).sendKeys(textValue);
   }
   
   public static String getPageTitle() {
       return driver.getTitle();
   }

   public static String getTextById(String locator) {
      return driver.findElement(By.id(locator)).getText();

   }

   public static String getAttributeAtLocatorByID(String locator, String attributeName) {
      return driver.findElement(By.id(locator)).getAttribute(
            attributeName);

   }

   public static String getAttributeAtLocatorByName(String locator,
         String attributeName) {
      return driver.findElement(By.name(locator)).getAttribute(attributeName);

   }

   public static String getAttributeAtLocatorByXpath(String locator,
         String attributeName) {
      return driver.findElement(By.name(locator)).getAttribute(attributeName);

   }

   public static List<WebElement> findElementsByXpath(String locator) {
      return driver.findElements(By.xpath(locator));
   }
   
   public static WebElement findElementByXpath(String locator) {
      return driver.findElement(By.xpath(locator));
   }

   public static boolean isElementPresentByXpath(String locator) {

      return driver.findElement(By.xpath(locator)).isDisplayed();

   }

   public static boolean isElementPresentByName(String locator) {

      return driver.findElement(By.name(locator)).isDisplayed();

   }
   public static void waitForElementToExist(By locator) {
      Wait<WebDriver> wait = new WebDriverWait(driver,
            DEFAULT_WAIT_IN_SECONDS);
      wait.until(ExpectedConditions.presenceOfElementLocated(locator));
   }
   
   public static void waitForElementToBeClickable(By locator) {
      Wait<WebDriver> wait = new WebDriverWait(driver,
            DEFAULT_WAIT_IN_SECONDS);
      wait.until(ExpectedConditions.elementToBeClickable(locator));
   }
   
   public static void waitForElementToDisappear(By locator) {
      Wait<WebDriver> wait = new WebDriverWait(driver,
            DEFAULT_WAIT_IN_SECONDS);
      wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
   }

   public static void acceptAlert() {
      driver.findElement(By.xpath("//UIAAlert"));
      Alert alert = driver.switchTo().alert();
      alert.accept();
   }

   public static void cancelAlert() {
      Alert alert = driver.switchTo().alert();
      System.out.println("Cancel Alert " + alert);
      alert.dismiss();
   }

   public static boolean isAlertPresent() {
      Alert alert = driver.switchTo().alert();
      return (alert == null);
   }

   public static String getValueByXpath(String xpath) {
      
      return driver.findElement(By.xpath(xpath)).getText();
   }
}