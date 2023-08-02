package com.org.examples.multithreading;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceCallableDemo {
	

	public static void main(String args[]) {
		
		Callable<String> callableTask = () -> {
			TimeUnit.MILLISECONDS.sleep(1000);
			return "Current time :: " + LocalDateTime.now();
		};
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		List<Callable<String>> tasksList = Arrays.asList(callableTask, callableTask, callableTask);
		
		try {
		List<Future<String>> results = 	executor.invokeAll(tasksList);
		for(Future<String> result : results) {
			System.out.println("Callable task result: "+result.get());
		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Future<String> result = executor.submit(callableTask);
		
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
		     
		
		executor.shutdown();
		
	}
}
