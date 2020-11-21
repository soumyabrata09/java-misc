package com.Exercises;
import java.util.Scanner;
/**
 * @author Sam
 *
 */
public class Permutation {

	/**
	 * @param str expects a string instance
	 * @param i expects an integer value
	 * @param j expects an integer value
	 * 
	 */
	public static String swap(String str , int i , int j) {
		char tempVar ;
		char []charArray = str.toCharArray();
		
		//swap each letter 
		tempVar = charArray[i];
		/*System.out.println("before swap charArray[i]-> "+charArray[i]);
		System.out.println("before swap-> charArray[j]"+charArray[j]+ "\n");*/
		charArray[i] = charArray[j];
		charArray[j] = tempVar;
		/*System.out.println("after swap charArray[i]-> "+charArray[i]);
		System.out.println("after swap-> charArray[j]"+charArray[j]);
		System.out.println("\n return value " + String.valueOf(charArray)+"\n");*/
		
		return String.valueOf(charArray);
	}
	
	public static void Permute(String str , int startIndex , int lastIndex) {
		
		if(startIndex == lastIndex ) {
			System.out.println(str);
		}
		else {
			for(int i = startIndex ; i <= lastIndex ; i++) {
				str = swap(str,startIndex,i);
				Permute(str , startIndex +1 , lastIndex);
				str =swap(str , startIndex , i);
			}
		}
	} 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string = ");
		String strVal = scanner.nextLine();
        Permutation.Permute(strVal , 0 , (strVal.length() - 1));

	}

}
