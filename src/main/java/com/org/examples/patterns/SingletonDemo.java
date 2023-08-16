package com.org.examples.patterns;

public class SingletonDemo {

	private static volatile SingletonDemo obj;
	
	private SingletonDemo() {
		System.out.println("SingletonDemo instance created");
	}
	
	public static SingletonDemo getInstance() {
		if(obj == null) {
			synchronized(SingletonDemo.class) {
				if(obj == null) 	
				  obj = new SingletonDemo();
			}
			
		}
			
		
		return obj;
	}
	
	public static void main(String[] args) {
		
		SingletonDemo obj1 = SingletonDemo.getInstance();
		SingletonDemo obj2 = SingletonDemo.getInstance();
		SingletonDemo obj3 = SingletonDemo.getInstance();
	}
}
