package com.org.examples.multithreading;

public class SynchronizedMethods {
	
	private int sum = 0;
	private int count = 0;
	public static int staticSum = 0;
	public static int staticCount = 0 ;

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void calculate() {
		setSum(getSum() + 1);
	}
	
	public synchronized void synchronisedCalculate() {
	    setSum(getSum() + 1);
	}
	
	 public static synchronized void syncStaticCalculate() {
	     staticSum = staticSum + 1;
	 }
	 
	 public void performSynchronizedTask() {
		 
		 synchronized(this) {
			 setCount(getCount()+1);
		 }
	 }
	 
	 public static void performStaticSyncTask() {
		 synchronized(SynchronizedMethods.class) {
			 staticCount = staticCount +1;
		 }
	 }

}
