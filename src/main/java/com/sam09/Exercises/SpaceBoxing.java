package com.sam09.Exercises;

import java.util.Scanner;

public class SpaceBoxing {
	public void caseStatement(int x,int str)
	{
	 
		switch(x)
		{
		case 1: 
			System.out.println("Your relative gravity in venus =0.78");
			System.out.println("Your weight will be"+ (0.78*str));
		break;
		case 2:
			System.out.println("Your relative gravity in Mars =0.39");
			System.out.println("Your weight will be"+ (0.39*str));
		break;
		case 3:
			System.out.println("Your relative gravity in Jupiter =2.65");
			System.out.println("Your weight will be"+ (2.65*str));
		break;
		case 4:
			System.out.println("Your relative gravity in Saturn =1.17");
			System.out.println("Your weight will be"+ (1.17*str));
		break;
		case 5:
			System.out.println("Your relative gravity in Uranus =1.05");
			System.out.println("Your weight will be"+ (1.05*str));
		break;
		case 6:
			System.out.println("Your relative gravity in Neptune =1.23");
			System.out.println("Your weight will be"+ (1.23*str));
		break;
		default:
			System.out.println("You enter wrong entry");
		}
	}

	
	public static void main(String[] sAmPrD) {
		
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter your weight");
    int b=sc.nextInt();
    System.out.println("Enter your choice");
    int n=sc.nextInt();
    SpaceBoxing obj=new SpaceBoxing();
    obj.caseStatement(n,b);
	}

}
