package com.org.examples.collections;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PriorityQueueExample {

	public static void main(String[] args) throws InterruptedException {
		PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
		ArrayList<Integer> polledElements = new ArrayList<>();
		
		queue.add(1);
		queue.add(5);
		queue.add(2);
		queue.add(3);
		queue.add(4);

		queue.drainTo(polledElements);

		//assertThat(polledElements).containsExactly(1, 2, 3, 4, 5);
         System.out.println(polledElements);
         
         PriorityBlockingQueue<Integer> queue2 = new PriorityBlockingQueue<>();
         
         new Thread(() -> {
        	 System.out.println("Polling...");
        	 
        	 try {
				Integer poll = queue2.take();
				System.out.println("Polled element: "+poll);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
         }).start();
         
         Thread.sleep(TimeUnit.SECONDS.toMillis(5));
         System.out.println("Adding to queue");
         queue.addAll(Arrays.asList(1, 5, 6, 1, 2, 6, 7));
         Thread.sleep(TimeUnit.SECONDS.toMillis(1));
	}

}
