package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class ReadConfig {

	Properties properties;
	String path ="config.properties";
	
	public ReadConfig() throws Exception {
		properties = new Properties();
		FileInputStream fis = new FileInputStream(path);
		properties.load(fis);
		
	}
	
	//User define method
	public String getBrowser() {
		String value = properties.getProperty("browser");
		
		if(value!=null) {
			return value;
		}else {
			throw new RuntimeException("Browaer is not found in config file");
		}
	}
}

