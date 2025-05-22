package com.sam09.Exercises;

import com.sam09.misc.utils.StringUtilities;

import java.util.Scanner;

public class ReversingString {

	public void reversingTheString(String str){
		String reverseString = "";
		for(int index = str.length()-1; index >=0; index--){
			reverseString += str.charAt(index);
		}
		System.out.print(reverseString);
	}
	public static void main(String[] sAmPrD) {
		Scanner scanner =new Scanner(System.in);
		System.out.print("Enter a sting to reverse= ");
		String input = scanner.nextLine();
		/*ReversingString obj=new ReversingString();
		obj.reversingTheString(n);*/
		System.out.println(" Reversed String of the given input(checking reverseUsingStack()) "
				+ input + " is: " + StringUtilities.reverseUsingStack(input) + "\n");

		System.out.println(" Reversed String of the given input(checking reverseUsingStack()) "
				+ input + " is: " + StringUtilities.reverseString(input));
	}

}
