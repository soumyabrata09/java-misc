package sAmPrD;
import java.util.Scanner;
public class Palindrome {
public void findingPalindrome(int x){
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
	public static void main(String[] sAmPrD) {
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter any number= ");
		int n=ob.nextInt();
    Palindrome obj=new Palindrome();
	obj.findingPalindrome(n);
	}

}
