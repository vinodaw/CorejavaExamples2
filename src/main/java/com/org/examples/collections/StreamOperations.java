package com.org.examples.collections;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamOperations {

	public static void main(String[] args) {
		
		Stream<Integer> s1 = Stream.of(1,2,3,4,5);
		
		//s1.forEach(System.out::print);
		
		Stream<Integer> s2 = Stream.concat(s1, Stream.of(6,7,8,9));
		
		s2.forEach(System.out::print);
		
		//array -> stream
		
		String[] strarray = {"a","b","c","d","e"};
		
		Stream<String> s3 = Arrays.stream(strarray);
		
		String[] strarray2 = s3.toArray(String[]::new);

	}

}
