package com.sam09.Exercises;

import java.util.Scanner;


public class EvenOdd {
 	
    public void Eval(int x)
    {
     	if(x%2==0)
    		System.out.print("number is Even");
    	else
    		System.out.print("number is Odd");
    	
    }

	public static void main(String[] sAmPrD) {
		Scanner ob=new Scanner(System.in);
		EvenOdd obj=new EvenOdd();
		System.out.print("Enter any number= ");
		int n=ob.nextInt();
		obj.Eval(n);

	}
}

