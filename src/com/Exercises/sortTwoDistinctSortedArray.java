package com.Exercises;

import java.util.Arrays;

/**
 * @author Sam
 *
 */
/*
 *input ar1={1, 5, 9, 10, 15, 20}
 * ar2 = {2, 3, 8, 13}
 * 
 * output will be : ar2->{1,2,3,5,8,9}
 *                ar2-> {10,13,15,20} 
 * 
 */
public class sortTwoDistinctSortedArray {

	/**
	 * @param ar1 expects an array of integers
	 * @param ar2 expects an array of integers
	 */
	//merge method which takes two array as its arguments
	public static void merge(int[] ar1, int[] ar2) {
		int m = ar1.length, n= ar2.length;
		//looping through the 2nd_array in reverse order
		for(int i = n-1 ; i>=0; i--) {
			int j;
			int last = ar1[m-1];
			//looping over the 1st_array in reverse order from the second last element.
			for(j = m-2 ; j>=0 && ar1[j]>ar2[i]; j--) {
				ar1[j+1] = ar1[j]; // moving elements one step forward 
			}
			//If there's a greater element then transfer the element from the second array to the first array
			if( j != m-2 || last > ar2[i] ) {
				ar1[j+1]=ar2[i];
				ar2[i] = last;
			}
		}
	}
	public static void main(String[] args) {
		
//		int arr1[] = new int[]{1, 5, 9, 10, 15, 20};
//	     int arr2[] = new int[]{2, 3, 8, 13};
		 int[] arr1 = { 10, 27, 38, 43 ,82 };
	        int[] arr2 = { 3,9 };
	     System.out.println("Before merging");
	     System.out.println("Arrays :- [" + Arrays.toString(arr1)+ "] & ["+ Arrays.toString(arr2)+"]");
	     sortTwoDistinctSortedArray.merge(arr1, arr2);
	     System.out.println("Arrays :- [" + Arrays.toString(arr1)+ "] & ["+ Arrays.toString(arr2)+"]");
	}

}
