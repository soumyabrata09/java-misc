/**
 * 
 */
package com.sam09.org.datastructure;

import com.sam09.Exceptions.StackOverFlowException;
import com.sam09.Exceptions.StackUnderFlowException;

/**
 * @author Sam
 *
 */
public class moi_Stack {
	
	static final int Maximum = 10000;
    public String array[] = new String[Maximum];  // defining the array with the maximum set stack frame length 
    int top;
    public moi_Stack() {
    	// set Top value to -1 
    	// As we are using array to implement our Stack hence we need to initialize top= -1 whenever moi_Stack() gets called for an instance creation
    	// as we know that array by default starts from the 0th position,thus we're going to exploit this default behavior of array[]
    	top = -1 ;
    }
    
    public boolean isEmpty() {
    	if(top<0)
    		return true;
    	else
    		return false;
    }
    
    public String peek() {
    	return "Top position is :-" + top +" and element is :"+array[top];
    }
    
    //implementing push() and pop()
    public void push(String value) throws StackOverFlowException {
    	// we need to take care of running out of stack size issue 
    	if(top > Maximum - 1 )
    	{
    		throw new StackOverFlowException();
    	}
    	else {
    		array[++top] = value;
    		return ;
    	}
    }
    
    public String pop() throws StackUnderFlowException {
    	if( top < 0) {
    		throw new StackUnderFlowException();
    		//return null;
    	}
    	else {
//    		top--;
    		return array[top--];
    	}
    }
}
