package com.sam09.Exercises;
import java.util.Scanner;
public class FibonacciIterative {

	public void fibonacci(int x){
		int sum=0,a=0,b=1,i=0;
		System.out.println("Fibonacci series :-");
		while(i<x){
			System.out.print(sum+" ");
			a=b;
			b=sum;
			sum=a+b;
			i++;
		}
	}
	public static void main(String[] sAmPrD) {
    Scanner ob=new Scanner(System.in);
    System.out.print("Enter a range= ");
    int n=ob.nextInt();
    FibonacciIterative obj=new FibonacciIterative();
    obj.fibonacci(n);
	}

}
