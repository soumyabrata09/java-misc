package com.Exercises;

import java.util.Scanner;

public class ReversingString {

	public void reversingTheString(String str){
		String s=" ";
		for(int i=str.length()-1;i>=0;i--){
			s+=str.charAt(i);
		}
		System.out.print(s);
	}
	public static void main(String[] sAmPrD) {
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter a sting to reverse= ");
		String n=ob.nextLine();
		ReversingString obj=new ReversingString();
		obj.reversingTheString(n);
	}

}
