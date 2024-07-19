package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	static Properties prop = new Properties();
	
	public static Properties intializeProperties() {
		
		File propFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
		
		try {
			
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}

}
