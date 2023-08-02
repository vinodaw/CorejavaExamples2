package com.org.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadFileFromResources {

	public static void main(String[] args) {
	
		ReadFileFromResources obj = new ReadFileFromResources();
		
		InputStream is = obj.getFileAsIOStream("logback.xml");
		
		try(InputStreamReader isr = new InputStreamReader(is)){
			BufferedReader br = new BufferedReader(isr);
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			is.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	private InputStream getFileAsIOStream(String fileName) {
		return this.getClass().getClassLoader().getResourceAsStream(fileName);
	}

}
