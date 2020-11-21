package com.Exercises;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Sam
 *
 */
public class checkEvenStrings {
	
	static String getEvenStr(String str) {
		Map<Character, Integer> hm = new HashMap<Character,Integer>();
		for(int i =0; i<str.length() ; i++) {
		  Integer count = hm.get(str.charAt(i));
		  if(hm.get(str.charAt(i)) == null)
			  hm.put(str.charAt(i), 1);
		  else
			  hm.put(str.charAt(i), ++count);
		}
		Set<Integer> set = new HashSet<Integer>(hm.values());
		System.out.println(set.size());
		if(set.size() == 1)
			return "Even Strings ";
		else
			return "Odd Strings ";
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a choice of your string = ");
		String str = scanner.nextLine();
		System.out.println(checkEvenStrings.getEvenStr(str));
	} 
}
