package com.Exercises;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Sam
 *
 */
//this code is designed with singleton design pattern 
// [phenomena : doubled checked thread safe approach to develop singleton classes 
public class TestAnagram {

	/**
	 * @param args for command line argument
	 */
	public static void main(String[] args) {
		Anagram obj = Anagram.getInstance();
		Scanner scanner = new Scanner(System.in);
		String str1,str2;
		System.out.println("Enter first string = ");
		str1 = scanner.nextLine();
		System.out.println("Enter second string = ");
		str2 = scanner.nextLine();
		obj.isAnagram(str1,str2);
		scanner.close();
	}

}

//Logic class 
class Anagram{

	private Anagram() {
		super();
	}
	
	private static volatile Anagram instance;
	public static Anagram getInstance() {
		if(instance == null) {
			synchronized(Anagram.class) {
				if(instance == null) {
					instance = new Anagram();
					
				}
			}
		}
		return instance;
	}


	@SuppressWarnings("unused")
	private String str1,str2;
	public boolean isAnagram(String str1, String str2) {
		this.str1 = str1; this.str2 = str2;
		if( str1.length() != str2.length())
		{
			System.out.println("Unequal Strings..");
			return false;
		}
		else {
			
		char[] char1 = str1.toCharArray(), char2 = str2.toCharArray();
		Arrays.sort(char1);
		Arrays.sort(char2);
		if( String.valueOf(char1).equals(String.valueOf(char2))) {
			System.out.println("Anagram Strings.."); 
			return true;
		}
		else {
			System.out.println("Not Anagram Strings.."); 
			return false;
		}
		}
	}
	
}
