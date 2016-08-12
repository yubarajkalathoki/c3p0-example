package com.yubaraj.c3p0.example;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Connects to database.
 * 
 * @author Yuba Raj Kalathoki
 * @version 1.0.0, Aug 9, 2016
 * @since 1.0.0
 */
public class DatabaseConnection {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConnection.class);

    public static Connection getConnection() {
	Connection cn = null;
	ComboPooledDataSource cpds = new ComboPooledDataSource();
	try {
	     cpds.setDriverClass(UtilityInitializer.configMap.get(ConfigConst.DATABASE_DRIVER));
	     // loads the jdbc driver
	     cpds.setJdbcUrl(UtilityInitializer.configMap.get(ConfigConst.DATABASE_SERVER));
	     cpds.setUser(UtilityInitializer.configMap.get(ConfigConst.DATABASE_USER));
	     cpds.setPassword(UtilityInitializer.configMap.get(ConfigConst.DATABASE_PASSWORD));
	    
	     // the settings below are optional -- c3p0 can work with defaults
	     cpds.setMinPoolSize(5);
	     cpds.setAcquireIncrement(5);
	     cpds.setMaxPoolSize(20);
	    
	     cn = cpds.getConnection();

//	    Class.forName(UtilityInitializer.configMap.get(ConfigConst.DATABASE_DRIVER));
//	    String server = UtilityInitializer.configMap.get(ConfigConst.DATABASE_SERVER);
//	    String username = UtilityInitializer.configMap.get(ConfigConst.DATABASE_USER);
//	    String password = UtilityInitializer.configMap.get(ConfigConst.DATABASE_PASSWORD);
//	    cn = DriverManager.getConnection(server, username, password);

	} catch (PropertyVetoException e) {
	    LOGGER.info(e.toString());
	} catch (SQLException e) {
	    LOGGER.info(e.toString());
	}
	return cn;
    }
}
