package com.yubaraj.c3p0.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Utility initializer class.
 * 
 * @author Yuba Raj Kalathoki
 * @version 1.0.0, Jun 14, 2016
 * @since 1.0.0
 */
public class UtilityInitializer {
    public static Map<String, String> configMap;
    private static Properties snsProperties;

    static {
	configMap = new HashMap<String, String>();

	snsProperties = new Properties();

	InputStream configStream = null;
	try {
	    /**
	     * Loads file from class path
	     */
	    // ClassLoader classloader =
	    // Thread.currentThread().getContextClassLoader();
	    // configStream =
	    // classloader.getResourceAsStream("application.properties");
	    /**
	     * loads file from default path
	     */
	    configStream = new FileInputStream("configuration.properties");
	    snsProperties.load(configStream);

	} catch (FileNotFoundException e1) {
	    e1.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    if (configStream != null) {
		try {
		    configStream.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}
    }

    public boolean init() {
	initConfig();
	return true;

    }

    private void initConfig() {
	// Database
	configMap.put(ConfigConst.DATABASE_SERVER, snsProperties.getProperty("database.url").trim());
	configMap.put(ConfigConst.DATABASE_USER, snsProperties.getProperty("database.username").trim());
	configMap.put(ConfigConst.DATABASE_PASSWORD, snsProperties.getProperty("database.password").trim());
	configMap.put(ConfigConst.DATABASE_DRIVER, snsProperties.getProperty("database.driver").trim());
    }
}
