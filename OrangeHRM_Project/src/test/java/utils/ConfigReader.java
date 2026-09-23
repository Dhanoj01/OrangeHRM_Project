package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	static Properties properties = new Properties();
	
	public static void loadProperties() throws IOException{
		
		FileInputStream file = new FileInputStream("src/test/resources/config.properties");
		
		properties.load(file);
		
		file.close();
	}
	
	public static String getProperty(String key)
	{
		return properties.getProperty(key);
	}
	
}
