package com.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Sam
 *
 */
public class FirstNonRepeatingCharacter {
	
	static void get1stNonRepChar(String str){
		Map<Character,Integer> hm = new LinkedHashMap<Character,Integer>();
		for(int i=0; i< str.length(); i++) {
			Integer count = hm.get(str.charAt(i));
			if( hm.get(str.charAt(i)) == null)
				hm.put(str.charAt(i), 1);
			else
				hm.put(str.charAt(i), ++count);
		}
		for(@SuppressWarnings("rawtypes") Map.Entry me : hm.entrySet()) {
			if(me.getKey() != null && me.getValue().equals(1)) {
				System.out.println("First non repeating character : " + me.getKey());
				break;
			}
			//System.out.println(me.getValue());
		}
	}

	public static void main(String[] ar) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter String = ");
		String str = scanner.nextLine();
		FirstNonRepeatingCharacter.get1stNonRepChar(str);
	} 
}
