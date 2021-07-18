package com.Exercises;

/* Figure As Follows:
 		*
		**
		***
		****
		***
		**
		*
*/

import java.util.Scanner;
public class PascalFigure {

	public void printingFigure(int x){
		for(int i=1;i<=x;i++){
			for(int j=1;j<=i;j++){
				System.out.print("*");
			}
			System.out.println(" ");
		}
		for(int n=1;n<=x;n++){
			for(int k=x;k>n;k--){
				System.out.print("*");
			}
			System.out.println(" ");
		}
	}
	public static void main(String[] sAmPrD) {
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter range= ");
		int n=ob.nextInt();
		PascalFigure obj=new PascalFigure();
		obj.printingFigure(n);
	}

}
