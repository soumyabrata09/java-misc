package com.sam09.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Sam
 *
 */
public class FirstNonRepeatingCharacter {
	
	static void getFirstNonRepeatingCharacter(String str) {
		Map<Character,Integer> hm = new LinkedHashMap<Character,Integer>();
		for(int i=0; i< str.length(); i++) {
			Integer count = hm.get(str.charAt(i));
			if( hm.get(str.charAt(i)) == null)
				hm.put(str.charAt(i), 1);
			else
				hm.put(str.charAt(i), ++count);
		}
		for(Map.Entry<Character,Integer> me : hm.entrySet()) {
			if(me.getKey() != null && me.getValue().equals(1)) {
				System.out.println("First non repeating character : " + me.getKey());
				break;
			}
			//System.out.println(me.getValue());
		}
	}

	public static String getFirstNonRepeatingCharacterByStream(String input) {
		/*char[] destinationCharacterArray = new char[input.length()];
		input.getChars(0, input.length(), input.toCharArray(), destinationCharacterArray[0]);*/

		String firstNonRepeatingCharacter = input.chars()
				.mapToObj(characterItem -> Character.valueOf((char) characterItem))
				.collect(Collectors.toMap(
						key -> key.toString(),
						value -> 1,
						Integer::sum
				)).entrySet()
				.stream()
				.filter(mapItem -> mapItem.getValue() == 1)
				.findFirst()
				.get()
				.getKey();

		return firstNonRepeatingCharacter;
	}

	public static void main(String[] ar) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter String = ");
		String inputValue = scanner.nextLine();
		FirstNonRepeatingCharacter.getFirstNonRepeatingCharacter(inputValue);
		System.out.println("First Non Repeating Character(Using Stream): "
				+ FirstNonRepeatingCharacter.getFirstNonRepeatingCharacterByStream(inputValue));
	} 
}
