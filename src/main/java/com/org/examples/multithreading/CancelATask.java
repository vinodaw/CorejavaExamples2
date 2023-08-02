package com.org.examples.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class CancelATask {

	public static void main(String[] args) {
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		
		ScheduledFuture<?> futureTask = executor.schedule(() -> { System.out.println("some tasks");}, 5, TimeUnit.SECONDS);
		
       System.out.println("Before Cancle - Task is done :"+futureTask.isDone());
       
       System.out.println("Before Cancle - Task is cancelled :"+futureTask.isCancelled());
       
       if (futureTask.isDone() == false) {
    	   futureTask.cancel(false);
    	    }

    	    System.out.println("After Cancel - Task is done : " + futureTask.isDone());
    	    System.out.println("After Cancel - Task is cancel : " + futureTask.isCancelled());

    	    executor.shutdown();
	}

}
