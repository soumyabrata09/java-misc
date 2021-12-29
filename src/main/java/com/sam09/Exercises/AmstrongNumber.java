package com.sam09.Exercises;
import java.util.Scanner;
public class AmstrongNumber {

	public void findingAmstrong(int x){
		int rem,y=0;
		int num=x;
		while(x>0){
			rem=x%10;
			x=x/10;
			y+=rem*rem*rem;
		}
		
		if(num==y)
			System.out.print("Number is amstrong number");
		else
			System.out.print("Number is not amstrong number");
	}
	public static void main(String[] sAmPrD) {
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter a number to check whether it is amstrong or not= ");
		int n=ob.nextInt();
		AmstrongNumber obj=new AmstrongNumber();
		obj.findingAmstrong(n);
	}

}
