package com.cucumber.helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configReader {

	public static String propertyFilepath = System.getProperty("user.dir")
			+ "\\src\\test\\resource\\Resource\\config.properties";

	public static Properties prop;

	public configReader() throws Throwable {
		try {
			File file = new File(propertyFilepath);
			FileInputStream fin = new FileInputStream(file);
			prop = new Properties();
			prop.load(fin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("file not in mention");
		}
	}

	public String getBrowserName() {
		String browserName = prop.getProperty("browserName");
		if (browserName != null) {
			return browserName;
		} else {
			throw new RuntimeException("browser name not found in properties file");
		}
	}

	public long getImplicitlywait() {
		String implicitlywait = prop.getProperty("implicitywait");
		if (implicitlywait != null) {
			return Long.parseLong(implicitlywait);
		} else

		{
			throw new RuntimeException("implicitywait not specified properties file.");

		}
	}

	public String geturl() {
		String url = prop.getProperty("url");
		if (url != null) {
			return url;
		} else {
			throw new RuntimeException("url not specified is the configuration.properties file.");

		}
	}
}