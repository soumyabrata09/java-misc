package com.Exercises;

/*
 * @author Sam
 *
 *
 * Dynamic Programming Java implementation of Coin Change problem
 */
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class CoinChangeProblem
{
	static long countWays(AtomicIntegerArray S, int m, int n)
	{
		/*Time complexity of this function: O(mn)
		Space Complexity of this function: O(n)

		 table[i] will be storing the number of solutions
		 for value i. We need n+1 rows as the table is
		 constructed in bottom up manner using the base
		 case (n = 0)*/
		long[] table = new long[n+1];
        int j ;
		// Initialize all table values as 0
		Arrays.fill(table, 0); //O(n)

		// Base case (If given value is 0)
		table[0] = 1;
//        List list = new ArrayList();
		/* Pick all coins one by one and update the table[]
		 values after the index greater than or equal to
		 the value of the picked coin*/
		for (int i=0; i<m; i++){
			//	list.add(table[j]);
			for ( j=S.get(i); j<=n; j++) {
				table[j] = table[j] + table[j - S.get(i)];
			}
			System.out.print("{");
			for (long l : table) {

				System.out.print(l);

			}
			System.out.println("}");
			System.out.println("---------------");
		}
		return table[n];
	}

	// Driver Function to test above function
	public static void main(String[] args)
	{
		AtomicIntegerArray arr = new AtomicIntegerArray(new int[]{1, 2, 3});
		int m = arr.length();
		int n = 7;
		System.out.println(countWays(arr, m, n));
	}
}
