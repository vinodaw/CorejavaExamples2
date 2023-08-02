package com.org.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingSLF4J {
	
	private static final Logger logger 
    = LoggerFactory.getLogger(LoggingSLF4J.class);

	public static void main(String[] args) {
		
		  logger.info("Example log from {}", LoggingSLF4J.class.getSimpleName());

	}

}
