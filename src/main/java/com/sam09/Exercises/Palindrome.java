package com.sam09.Exercises;
import com.sam09.misc.utils.StringUtilities;

import java.util.Scanner;
public class Palindrome {
public static void findingPalindrome(int x){
	int rem,y=0;
	int num=x;
	while(x>0){
		rem=x%10;
		x=x/10;
		y=y*10+rem;
	}
	if(num==y)
		System.out.print("Number is palindrome");
	else
		System.out.print("Number isn't palindrome");
}

	public static void checkPalindromeString(String inputValue) {
		/*String reversedString = "";
		for (int index = inputValue.length(); index >0; index--) {
			reversedString += inputValue.charAt(index-1);
		}
		if (inputValue.equals(reversedString))
			System.out.println("Given input string " + inputValue + " is palindrome");
		else
			System.out.println("Given input string " + inputValue + " is not palindrome");*/

		/*String reversedString = StringUtilities.reverseUsingStack(inputValue);*/
		boolean flag = StringUtilities.isPalindrome(inputValue);
		if (flag)
			System.out.println("Given input string " + inputValue + " is palindrome");
		else
			System.out.println("Given input string " + inputValue + " is not palindrome");
	}
	public static void main(String[] sAmPrD) {
		Scanner scanner=new Scanner(System.in);
		/*System.out.print("Enter any number= ");
		int n=scanner.nextInt();*/
		System.out.println("Enter a String: ");
		String inputValue = scanner.nextLine();
//		findingPalindrome(n);
		checkPalindromeString(inputValue);
	}

}
