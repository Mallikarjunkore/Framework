package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains reusable methods to perform actions on properties from
 * @author Mallikarjun
 *
 */

public class propertiesUtility {
	private Properties property;
	/**
	 * this method is used to initialize properties file
	 * @param filepath
	 */
	
	public void propertiesInit(String filepath) {
		FileInputStream fis= null;
		try {
			fis=new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		property=new Properties();
		
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to fetch the data from properties file using key
	 * @param key 
	 * @return 
	 */
	public String fetchDataFromProperties(String key) {
		return property.getProperty(key);
	}
	/**
	 * this method is used to write data into properties file
	 * @param key
	 * @param value
	 * @param filepath
	 * @param comments
	 */
	
	public void writeDataToProperties(String key,String value, String filepath, String comments) {
		FileOutputStream fos=null;
		property.put(key, value);
		
		try {
			fos=new FileOutputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			property.store(fos, comments);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
