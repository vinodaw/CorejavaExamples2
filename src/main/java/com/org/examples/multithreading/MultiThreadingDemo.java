package com.org.examples.multithreading;

public class MultiThreadingDemo {

	public static void main(String[] args) {
	
		
		 
		 for(int i=0;i<10;i++) {
			 MultiThread1 thread1 = new MultiThread1();
			 thread1.start();	 
		 }
		 
		 for(int i=0;i<10;i++) {
			 Thread thread2 = new Thread(new MultiThread2());
			 thread2.start();	 
		 }
		 

	}

}

class MultiThread1 extends Thread {

	@Override
	public void run() {
		
		
		try {
			Thread.sleep(500);
			System.out.println("Thread1 "+Thread.currentThread().getId() +" is running");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class MultiThread2 implements Runnable {

	@Override
	public void run() {
	
		System.out.println("Thread2 "+Thread.currentThread().getName() +" is running");
		
	}
	
}
