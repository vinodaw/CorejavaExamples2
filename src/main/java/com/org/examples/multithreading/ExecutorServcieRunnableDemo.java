package com.org.examples.multithreading;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServcieRunnableDemo {
	
	public static void main(String[] args) {
		// task
		Runnable runnableTask = () -> {
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
				System.out.println("Current time: "+LocalDateTime.now());
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		//execute task using execute method
		executor.execute(runnableTask);
		
		Future<String> result = executor.submit(runnableTask, "DONE");
		
		 while(result.isDone() == false) 
		    {
		      try
		      {
		        System.out.println("The method return value : " + result.get());
		        break;
		      } 
		      catch (InterruptedException | ExecutionException e) 
		      {
		        e.printStackTrace();
		      }
		       
		      //Sleep for 1 second
		      try {
		        Thread.sleep(1000L);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		    }
		 
		//Shut down the executor service
		    executor.shutdownNow();
	}

}
