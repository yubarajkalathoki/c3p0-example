package com.yubaraj.c3p0.example;

import java.sql.Connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * It processes the application.
 * 
 * @author Yuba Raj Kalathoki
 * @version 1.0.0, Aug 10, 2016
 * @since 1.0.0
 */
public class Processor implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class);

    public void run() {
	Connection cn = null;
	while (true) {
	    if (cn == null) {
		cn = DatabaseConnection.getConnection();
	    }
	    if (cn != null) {
		LOGGER.info("Database Connected!");
		waiting();
	    } else {
		LOGGER.info("Failed to connect!");
		waiting();
	    }
	}
    }

    private void waiting() {
	try {
	    Thread.sleep(10000L);
	} catch (InterruptedException e) {
	    LOGGER.info(e.toString());
	}
    }
}
