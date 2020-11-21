package com.Exercises;

import java.util.Arrays;

/*
 * @author Sam
 *
 */
public class MergeTwoSortedArrays {
	
	private static void mergeArrays(int[] ar1, int m, int[] ar2, int n, int[] ar3) {
		int i=0,j=0,k=0;
		while( i< m && j<n) {
			if(ar1[i] < ar2[j])
				ar3[k++] = ar1[i++];
			else
				ar3[k++] = ar2[j++];
		}
	}

	public static void main(String[] arg) {
		int[] ar1 = {1, 3, 5, 7};
		int[] ar2 = {2, 4, 6, 8};
		int m = ar1.length,n=ar2.length;
		int[] ar3 = new int[m+n];
		MergeTwoSortedArrays.mergeArrays(ar1,m,ar2,n,ar3);
		System.out.println(Arrays.toString(ar3));
	}

	
}
