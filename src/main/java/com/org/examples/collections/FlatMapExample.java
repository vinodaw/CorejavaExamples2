package com.org.examples.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

	public static void main(String[] args) {
		
		List<String> listOfStrings = Arrays.asList("1","2","3","4","5","6");
		
		
		//stream.map ex
		List<Integer> listOfInts = listOfStrings.stream().map(x -> Integer.valueOf(x)).collect(Collectors.toList());
		
		System.out.println("listOfInts: "+listOfInts);
		
		List<String> list1 = Arrays.asList("1","2","3");
		List<String> list2 = Arrays.asList("4","5","6");
		List<String> list3 = Arrays.asList("7","8","9");
		  
		List<List<String>> listOfLists = Arrays.asList(list1, list2, list3);
		
		List<Integer> listOfInts2 = listOfLists.stream().flatMap(x -> x.stream()).map(x -> Integer.valueOf(x)).collect(Collectors.toList());
		
		System.out.println("listOfInts2: "+listOfInts2);

	}

}
