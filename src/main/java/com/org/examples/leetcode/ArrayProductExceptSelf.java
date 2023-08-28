package com.org.examples.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayProductExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,1,0,-3,3};
		productExceptSelf(nums);
		
		
	}
	
	 public static int[] productExceptSelf(int[] nums) {
	        
		 int[] answer = new int[nums.length];
		 
		/*
		  for(int i=0;i<nums.length;i++) {
			  
			  int leftProduct = 1,rightProduct=1;
			  
			  
			  if(i > 0)
			  {
				 
				
				  for(int j=0;j<i;j++) {
					
					
					  leftProduct = Math.multiplyExact(leftProduct, nums[j]); 
				  }
				  
				
				  
				  
				  for(int j=i+1;j<nums.length;j++) {
					  rightProduct = Math.multiplyExact(rightProduct, nums[j]); 
				  }
				  
				  
				 answer[i] = Math.multiplyExact(leftProduct , rightProduct);
				 
				 
			  }
			  
			  if(i == 0) {
				  rightProduct = 1;
				  for(int j=i+1;j<nums.length;j++) {
					  rightProduct = Math.multiplyExact(rightProduct, nums[j]); 
				  }
				 
				  answer[i] = rightProduct;
			  }
			  
			  System.out.println("answer at index: "+i+" is: "+answer[i]);
		  }
		  */
		  //using lists
		  
		/*  List<Integer> list = new ArrayList<Integer>();
			
			for(int i=0;i<nums.length;i++)
				list.add(nums[i]);
			
			  for(int i=0;i<nums.length;i++) {
				  
				  int leftProduct = 1,rightProduct=1;
				  
				  if(i > 0)
				  {
					 
					
					  for(int j=0;j<i;j++) {
						
						
						  leftProduct = Math.multiplyExact(leftProduct, list.get(j)); 
					  }
					  
					
					  
					  
					  for(int j=i+1;j<nums.length;j++) {
						  rightProduct = Math.multiplyExact(rightProduct, list.get(j)); 
					  }
					  
					  
					 answer[i] = Math.multiplyExact(leftProduct , rightProduct);
					 
					 
				  }
				   else {
					  rightProduct = 1;
					  for(int j=i+1;j<nums.length;j++) {
						  rightProduct = Math.multiplyExact(rightProduct, list.get(j)); 
					  }
					 
					  answer[i] = rightProduct;
				  }
				  
				  System.out.println("answer at index: "+i+" is: "+answer[i]);
				  
			  }
			  
			  
			  */
		 int n = nums.length;
		 
		 for(int i=0;i<n;i++) {
			 int product = 1; 
			 for(int j=0;j<n;j++) {
				 if(i == j) continue;
				 product *= nums[j];
			 }
			 answer[i] = product;
			 System.out.println("answer at index: "+i+" is: "+answer[i]);
		 }
			  
			
			
		           
		 return answer;
	
	 }

}
