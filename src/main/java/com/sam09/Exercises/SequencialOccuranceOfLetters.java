/*
 * 
 * You are given three inputs: a string, one letter, and a second letter.
	Check if every instance of the first letter occurs before every instance of the second letter.
	Constraints:
	1.	All strings will be in lower case
	2.	All strings will contain the first and second letters at least once
	Input Format
	Three string value of string, first & second
	Output Format
	Print 'True' if the first letter occurs before every instance of the second letter, otherwise print 'False'
	Sample Input 1
	"a rabbit jumps joyfully", "a", "j"
	Sample Output 1
	True
	 
	# Every instance of "a" occurs before every instance of "j".
	Sample Input 2
	"knaves knew about waterfalls", "k", "w"
	Sample Output 2
	True
	Sample Input 3
	"happy birthday", "a", "y"
	Sample Output 3
	False
	 
	# The "a" in "birthday" occurs after the "y" in "happy".

 */
package com.sam09.Exercises;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author soumyabrata
 *
 */
public class SequencialOccuranceOfLetters {

	/**
	 * @param args for command line argument
	 */
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the sentence and first & second letter : \t");
		String sentence = scanner.nextLine();
		Character firstLetter = scanner.nextLine().charAt(0);
		Character secondLetter = scanner.nextLine().charAt(0);
		Stack<Character> stack = new Stack<Character>();
		Boolean flagValue = Boolean.FALSE;
		System.out.println( sentence + "/ " + firstLetter + " / " + secondLetter );
		
		/*
		 * Utilizing Stack here in order to keep a track of occurrences of the desired letters only
		 * Initially element will get added to tack instance
		 * Then check for only firstLetter / secondLetter 
		 * Adding element to stack will be done in following cases
		 * If stack is empty 
		 * If current character is firstLetter and stack.peek() {this does not deletes elements , it is for peeking purpose as the name is suggesting}
		 * to see whether previous stack top is firstLetter --> set flagValue to True
		 * If current character is secondLetter and stack.peek() is firstletter add element to stack --> set flagValue to True
		 * If current character is secondLetter and stack.peek() is secondLetter add element to stack --> set flagValue to True
		 * If current character is firstLetter and stack.peek() is secondLetter --> set flagValue to False and Break out from execution cycle
		 * */
		
		for(int i =0; i< sentence.length(); i++) {
			if(sentence.charAt(i) == firstLetter || sentence.charAt(i) == secondLetter) {
				if(stack.isEmpty()) {
					stack.add(sentence.charAt(i));
					flagValue = Boolean.TRUE;
				}
				else {
					if(sentence.charAt(i) == firstLetter && stack.peek() == firstLetter) {
						stack.add(sentence.charAt(i));
						flagValue = Boolean.TRUE;
					}
					if(sentence.charAt(i) == secondLetter && stack.peek() == firstLetter) {
						stack.add(sentence.charAt(i));
						flagValue = Boolean.TRUE;
					}
					if(sentence.charAt(i) == firstLetter && stack.peek() == secondLetter) {
						flagValue = Boolean.FALSE;
						break;
					}
					if(sentence.charAt(i) == secondLetter && stack.peek() == secondLetter) {
						stack.add(sentence.charAt(i));
						flagValue = Boolean.TRUE;
					}
				}
			}
			
		}
		System.out.println("Output : " + flagValue);
	}

}


