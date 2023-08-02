package com.org.examples.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.org.examples.LoggingSLF4J;

public class HashMapExample {
	
	private static final Logger logger 
    = LoggerFactory.getLogger(HashMapExample.class);

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "D");
		map.put(5, "E");
		map.put(6, "F");
		map.put(7, "G");
		
		Iterator itr1 = map.keySet().iterator();
		
		while(itr1.hasNext()) {
			Integer key = (Integer) itr1.next();
			logger.info("Value at "+key + "position is :"+map.get(key));
		}
		
		Iterator<Entry<Integer,String>> entryIterator = map.entrySet().iterator();
		
		while (entryIterator.hasNext())
		{
		    Entry<Integer, String> entry = entryIterator.next();

		    logger.info("The key is :: " + entry.getKey() + ", and value is :: " + entry.getValue() );
		}

	}

}
