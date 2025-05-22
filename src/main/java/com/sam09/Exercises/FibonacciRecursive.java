package com.sam09.Exercises;
import java.util.Scanner;

public class FibonacciRecursive {
 public int fibonacci(int x){
	 if (x==0)
		 return 0;
	 else if(x==1)
		 return 1;
	 else
		 return fibonacci(x-1)+fibonacci(x-2);
 }
	public static void main(String[] args) {
	Scanner ob=new Scanner(System.in);
	System.out.print("Enter a range= ");
	int n=ob.nextInt();
	FibonacciRecursive obj=new FibonacciRecursive();
	int counter=0;
	System.out.println("Fibonacci series :-");
	for(int i=0;i<n;i++){
		System.out.print(obj.fibonacci(counter)+" ");
		counter++;
	}
	
	}

}
