package com.sam09.Exercises;
import java.util.Scanner;
public class Prime {
   public void findingPrime(int x){
	 boolean flag=true;
	   for(int i=2;i<x/2;i++){
		if(x%i==0){
			flag=false;
			break;
		} 
	 }
	   if(flag){
		   System.out.print("Number is Prime");
	   }
	   else{
		   System.out.print("Number is not Prime");
	   }
   }
	public static void main(String[] sAmPrD) {
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter a number to check whether it is prime or not..= ");
		int n=ob.nextInt();
		Prime obj=new Prime();
		obj.findingPrime(n);
	}

}
