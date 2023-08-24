package com.org.examples.leetcode;

public class ReverseWords {

	public static void main(String[] args) {
		String s = "a good   example";
		
		String[] arr = s.split(" ");
		System.out.println("size: "+arr.length);
		StringBuilder builder = new StringBuilder("");
		for(int i = arr.length-1; i >= 0 ; i--) {
			System.out.println("str: "+arr[i].length());
			
			if(arr[i].length() > 0)
			builder.append(arr[i].trim()).append(" ");
		}
		System.out.println("final str: "+builder.toString().trim());
	}

}
