package com.org.examples.collections;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CollectStreamExampple {

	public static void main(String[] args) {
		
		var unmodifiableList = Arrays.asList(1,2,3,4,5).stream().collect(Collectors.toUnmodifiableList());
		
		var unmodifiableSet = Arrays.asList(1,1,2,3,4,4,5,6).stream().collect(Collectors.toUnmodifiableSet());
		
		System.out.println("Unmodifiable list: "+unmodifiableList);
		
		System.out.println("Unmodifiable list: "+unmodifiableSet);

	}

}
