package com.yubaraj.c3p0.example;

/**
 * Starter class.
 * 
 * @author Yuba Raj Kalathoki
 * @version 1.0.0, Aug 10, 2016
 * @since 1.0.0
 */
public class Starter {
    public static void main(String[] args) {
	UtilityInitializer initializer = new UtilityInitializer();
	if (initializer.init()) {
	    Processor processor = new Processor();
	    Thread t = new Thread(processor);
	    t.start();
	}
    }
}
