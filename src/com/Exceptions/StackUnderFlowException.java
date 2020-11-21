package com.Exceptions;
/**
 * 
 */


/**
 * @author Sam
 *
 */

public class StackUnderFlowException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2246495546967667761L;

	public StackUnderFlowException() {
		System.out.println("com.Exceptions.StackUnderFlowException thown:  Stack is Empty");
	}
}
