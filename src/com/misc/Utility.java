package com.misc;

import com.Exceptions.StackOverFlowException;
import com.Exceptions.StackUnderFlowException;
import com.org.DataStructure.moi_Stack;

/**
 * @author Sam
 * @version 0.1
 */
public class Utility {

  // reverse string using data structure - stack [moi_Stack]

	public static void reverseString(String string) throws StackOverFlowException, StackUnderFlowException {
		//Break the string into character
		moi_Stack stack = new moi_Stack();
		for(int i=0; i< string.length(); i++) {
			Character character = string.charAt(i);
			stack.push(character.toString());
		}
		StringBuilder revString = new StringBuilder();
		while(!stack.isEmpty()) {
			
			revString.append(stack.pop());
		}
		System.out.println(revString);
	}
}
