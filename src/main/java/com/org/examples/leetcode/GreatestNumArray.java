package com.org.examples.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GreatestNumArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candies = {4,2,1,1,2};
		List<Boolean> result = kidsWithCandies(candies,1);
		System.out.println("result: "+result);
	}
	
	 public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
	        List<Boolean> result = new ArrayList<Boolean>();
	        int max = 0;
	        
	        max = candies[0];
	        for(int i=0;i<candies.length;i++) {
	        	if(candies[i] > max)
	        		max = candies[i];
	        }
	        
	        System.out.println("max: "+max);
	        
	        for(int i=0;i<candies.length;i++) {
	        	if((candies[i]+extraCandies) >= max)
	        		result.add(true);
	        	else
	        		result.add(false);
	        }
	        
	        return result;
	 }

}
