package com.sam09.Exercises;
import java.util.Scanner;
public class FactorialRecursive {

	public int factCal(int x){
		if(x==0 )
			return 1;
		else{
			return x*factCal(x-1);
		}
	}
	public static void main(String[] sAmPrD) {
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter a number= ");
        int n=ob.nextInt();
		FactorialRecursive obj=new FactorialRecursive();
        System.out.print(obj.factCal(n));
	}

}
