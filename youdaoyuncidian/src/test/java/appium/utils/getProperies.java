package appium.utils;

import java.util.Properties;
import java.io.*;

public class getProperies {
	public Properties pro = new Properties();

	public getProperies(String fileName) {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName);
		try {
			pro.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String readProperties(String key) {
		String value = pro.getProperty(key);
		return value;

	}
}
