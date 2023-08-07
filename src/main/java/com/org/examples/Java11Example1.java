package com.org.examples;

import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Java11Example1 {
	
	private static final Logger logger 
    = LoggerFactory.getLogger(Java11Example1.class);

	public static void main(String[] args) {
		String multilineString = "Baeldung helps \n \n developers \n explore Java.";
		List<String> lines = multilineString.lines()
		  .filter(Predicate.not(String::isBlank)) //filter(line -> !line.isBlank())
		  .map(String::strip)
		  .collect(Collectors.toList());
		
		logger.debug("lines: "+lines);

	}

}
