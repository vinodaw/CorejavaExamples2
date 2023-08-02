package com.org.examples.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		
		Queue<String> q = new LinkedList<String>();
		
		 //Adding elements to the Queue
	      q.add("Rick");
	      q.add("Maggie"); 
	      q.add("Glenn");
	      q.add("Negan");
	      q.add("Daryl");
	      
	      System.out.println("Elements in Queue:"+q);
	      System.out.println("Removed element: "+q.remove());
	      System.out.println("Head: "+q.element());
	      System.out.println("poll(): "+q.poll());
	      System.out.println("peek(): "+q.peek());
	      System.out.println("Elements in Queue:"+q);
	      
	      Deque<String> dq = new ArrayDeque<String>();
	      
	      dq.add("Glenn");
	  	dq.add("Negan");
	  	dq.addLast("Maggie");
	  	dq.addFirst("Rick");
	  	dq.add("Daryl");
	  	
	  	System.out.println("Elements in Deque:"+dq);
	  	
	  	System.out.println("Removed element: "+dq.removeLast());
	  	
	  	System.out.println("Head: "+dq.element());
	  	
	  	System.out.println("poll(): "+dq.pollLast());
	  	
	  	System.out.println("peek(): "+dq.peek());
	  	
	  	System.out.println("Elements in Deque:"+dq);

	}

}
