package com.org.examples.leetcode;

public class MergeStringsAlt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mergeAlternately("abcd","pq");
		
		mergeAlternately("ab","pqrs");
		
		mergeAlternately("abc","pqr");
	}

    public static String mergeAlternately(String word1, String word2) {
        String mergedStr = "";
      
        if(word1.length() > word2.length()) {
        	for(int i=0;i<word2.length();i++) {
        		mergedStr = mergedStr + word1.charAt(i) + word2.charAt(i);
        	}
        	mergedStr += word1.substring(word2.length());
        	System.out.println("mergedStr: "+mergedStr);
        } else if(word1.length() < word2.length()) {
        	for(int i=0;i<word1.length();i++) {
        		mergedStr = mergedStr + word1.charAt(i) + word2.charAt(i);
        	}
        	mergedStr += word2.substring(word1.length());
        	System.out.println("mergedStr: "+mergedStr);
        } else {
        	for(int i=0;i<word1.length();i++) {
        		mergedStr = mergedStr + word1.charAt(i) + word2.charAt(i);
        	}
        	//mergedStr += word2.substring(word1.length());
        	System.out.println("mergedStr: "+mergedStr);
        }
    	return mergedStr;
    }
}
