package com.org.examples.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
	
	private final ReentrantLock relock = new ReentrantLock();
	private int count = 0;
	
	public int getCount() {
		relock.lock();
		try {
			
			System.out.println(Thread.currentThread().getName() +"get count: "+ count);
			return count++;
		} finally {
			relock.unlock();
		}
	}
	
	public synchronized int getCountSync() {
		
			System.out.println(Thread.currentThread().getName() +"get count: "+ count);
			return count++;
		
	}

	public static void main(String[] args) {
		ReentrantLockExample obj = new ReentrantLockExample();
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				while (obj.getCount() < 6) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();                    
                        
                    }
                }
			}
		};
		
		Thread t2 = new Thread() {

            @Override
            public void run() {
                while (obj.getCountSync() < 6) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };



		
		t1.start();
		t2.start();

	}

}
