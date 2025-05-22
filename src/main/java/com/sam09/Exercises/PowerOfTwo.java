package com.sam09.Exercises;

import java.util.Scanner;

public class PowerOfTwo {
public void findingPowerofTwo(int x){
    boolean flag=true;
    for(int i=0;i<x/2;i++){
    	if(x==Math.pow(2,i)){
    		flag=true;
    	}else flag=false;
    	}
    	if(flag)
    		System.out.print("Number is power of two");
    	else
    		System.out.print("Number is not power of two");
    
}
	public static void main(String[] sAmPrD) {
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter any number to check if it is power of two= ");
		int n=ob.nextInt();
		PowerOfTwo obj=new PowerOfTwo();
        obj.findingPowerofTwo(n);
	}

}
