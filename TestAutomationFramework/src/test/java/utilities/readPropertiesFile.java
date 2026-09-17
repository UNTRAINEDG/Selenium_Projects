package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readPropertiesFile 
{
     public static void main(String[] args) throws IOException
     {
    	 Properties prop = new Properties();
    	 FileInputStream file = new FileInputStream("C:\\Users\\nitis\\eclipse-workspace\\TestAutomationFramework\\src\\test\\resources\\configfiles\\config.properties");
    	 prop.load(file);
    	 System.out.println(prop.getProperty("browser"));
    	 System.out.println(prop.getProperty("testUrl"));
    	 
    	 
     }
}	
