package com.org.examples;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWords {

	public static void main(String[] args) {
		String input = "alex brian charles";
		
		String[] words = input.split(" ");
		
		String reversedStr = Arrays.stream(words).map(x -> new StringBuilder(x).reverse()).collect(Collectors.joining(" "));
		
		System.out.println("reversedStr: "+reversedStr);
		
		//without using functions
		String revStr = "",revWord="",word="";
		for(int i=0;i<words.length;i++) {
			word = words[i];
			revWord="";
			for(int j=word.length()-1;j>=0;j--) {
				revWord = revWord + word.charAt(j);
			}
			revStr = revStr +" "+ revWord;
		}
      System.out.println("revStr: "+revStr);
	}

}
