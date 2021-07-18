package com.Exercises;
import java.util.Scanner;

public class SortingArrayElements {
 public void sortingElem( int arr[]){
	 for(int i=0;i<arr.length;i++){
		 for(int j=i+1;j<arr.length;j++){
			 if(arr[i]>arr[j]){
				 int temp=arr[j];
				 arr[j]=arr[i];
				 arr[i]=temp;
			 }
		 }
	 }
	 for(int k:arr){
		 System.out.print(k+",");
	 }
 }
	public static void main(String[] sAmPrD) {
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter no. of array elements= ");
        int n=ob.nextInt();
        int [] ar= new int[n];
        System.out.print("Enter array elements= ");
        for(int i=0;i<n;i++){
        	ar[i]=ob.nextInt();
        }
		SortingArrayElements obj=new SortingArrayElements();
        obj.sortingElem(ar);
	}

}
