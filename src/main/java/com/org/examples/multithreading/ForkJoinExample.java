package com.org.examples.multithreading;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkJoinExample {

	public static void main(String[] args) {
		
		ForkJoinPool pool = new ForkJoinPool();
	    FolderProcessor downloads = new FolderProcessor("/Users/Downloads", "log");
	    
	    pool.execute(downloads);
	    
	    do {
	    	  System.out.printf("******************************************\n");
	          System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
	          System.out.printf("Main: Active Threads: %d\n",
	              pool.getActiveThreadCount());
	          System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
	          System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
	          System.out.printf("******************************************\n");
	          
	          try {
	              TimeUnit.SECONDS.sleep(1);
	            } catch (InterruptedException e) {
	              e.printStackTrace();
	            }
	          
	    } while(!downloads.isDone());
	    
	    pool.shutdown();
	    
	    List<String> results;
	    results = downloads.join();
	    System.out.printf("System: %d files found.\n", results.size());

	}

}
