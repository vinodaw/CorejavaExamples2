package com.org.examples.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		
		Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8);
		
		stream.forEach(p -> System.out.println(p));
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<10;i++)
			list.add(i);
		
		Stream<Integer> stream2 = list.stream();
		
		stream2.forEach(p -> System.out.print(p));
		
		Stream<Integer> s3 = Stream.generate(() -> (new Random().nextInt(100)));
		
		s3.limit(20).forEach(System.out::println);
		
		//Boxed Streams
		
		Stream<Integer> s4 = IntStream.of(1,2,3,4,5,6).boxed();
		
		Stream<Double> s5 = DoubleStream.of(1.0,2.0,3.0,4.5).boxed();
		
		

	}

}
