package com.Exceptions;
/**
 * 
 */


public class StackOverFlowException extends Exception {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 6523683958432915146L;

	public StackOverFlowException(){
		System.out.println("com.Exceptions.StackOverFlowException thown:  Stack is Full");
		return ;
	}
}
