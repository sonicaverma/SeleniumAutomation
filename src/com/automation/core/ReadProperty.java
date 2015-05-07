package com.automation.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty
{

   static Properties prop ;
   static String PropertyFilePath = "resources\\config.properties";
   
   //Return Property value
   public static String getProperty(String key)
   {
      prop = loadProperty(PropertyFilePath,prop);
      return prop.getProperty(key);
   }
   
 
   public static Properties loadProperty(String filePath, Properties property)
   {
      property = new Properties();
       try {      
         property.load(new FileInputStream(new File(filePath)));
          } 
    catch (IOException e) {
       e.printStackTrace();
    }   
       return property;
   }
   
   
}
