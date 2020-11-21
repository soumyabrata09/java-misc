/**
 * 
 */
package com.Exercises;

import com.Exceptions.StackOverFlowException;

/**
 * @author Sam
 *
 */

/*
 * This program is about finding the balanced parenthesis from a given expression 
 * */
public class BalancedParenthesis {

	public static class stack{
		private int top = -1;
		private char[] item = new char[1000];
		public void push(char exp) {
			if(top==1000) {
				try {
					throw new StackOverFlowException();
				}
				catch(StackOverFlowException ex) {
					ex.printStackTrace();
				}
			}
			else {
				item[++top]=exp;
			}
		}
		public char pop() {
			if(top == -1) {
				System.out.println("Stack is Empty");
				return '\0';
			}
			else {
				char elem = item[top];
				top--;
				return elem;
			}
		}
		public boolean isEmpty() {
			return (top == -1) ? true : false;
		}
	}
	public boolean addExp(char[] exp) {
		stack stack = new stack();
		for(int i =0; i< exp.length ; i++) {
			if( exp[i] == '(' || exp[i] == '{' || exp[i] == '[')
				stack.push(exp[i]);
			if( exp[i] == ')' || exp[i] == '}' || exp[i] == ']') {
				if(stack.isEmpty())
					return false;
				else if( !isMatched(stack.pop(),exp[i]))
					return false;
//				else
//					return true;
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
	public boolean isMatched(char ch1, char ch2) {
		if(ch1 == '(' && ch2 == ')')
			return true;
		if(ch1 == '{' && ch2 == '}')
			return true;
		if(ch1 == '[' && ch2 == ']')
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		char expression[] = {'{','(',')','}','[','{','(',')','}',']'};
		//char exp[] = {'{','(',')','}','[',']'};
		BalancedParenthesis obj = new BalancedParenthesis();
		if(obj.addExp(expression))
			System.out.println("Parantheses are BALANCED...");
		else
			System.out.println("Parentheses are NOT BALANCED");

	}

}
