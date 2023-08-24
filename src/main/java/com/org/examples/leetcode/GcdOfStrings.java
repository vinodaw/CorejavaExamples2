package com.org.examples.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GcdOfStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gcdOfStrings("ABCABC","ABC");
		gcdOfStrings("ABABAB","ABAB");
		gcdOfStrings("LEET","CODE");
		gcdOfStrings("ABCDEF","ABC");
		
		System.out.println("Test case1 "+gcdOfStrings("ABCABC","ABC"));
		System.out.println("Test case2: "+gcdOfStrings("ABABAB","ABAB"));
		System.out.println("Test case3: "+gcdOfStrings("LEET","CODE"));
		System.out.println("Test case4: "+gcdOfStrings("AAAA","AA"));
	}
	
	
	 public static String gcdOfStrings(String str1, String str2) {
		 
		 // Check if concatenated strings are equal or not, if not return ""
	        if (!(str1 + str2).equals(str2 + str1))
	            return "";
	        // If strings are equal than return the substring from 0 to gcd of size(str1), size(str2)
	        int gcd = gcd(str1.length(), str2.length());
	        return str1.substring(0, gcd);
	        
	 }
	 
	   private static int gcd(int a, int b) {
	        return b == 0 ? a : gcd(b, a % b);
	    }

}
