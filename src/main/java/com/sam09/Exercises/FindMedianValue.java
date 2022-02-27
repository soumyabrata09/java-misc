package com.sam09.Exercises;

import com.sam09.misc.utils.ArrayUtility;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Soumyabrata09
 *
 * Find the median of a given array of integers( staring point: array-index =1 ) where staring and ending index would be given and based on them
 * need to find the median of the sorted sub-array.
 * Median: ceiling( length_of_array / 2)
 * Considerations: Array would be considered as staring from index=1
 *  Input : Array range -> R
 *  Input: space separated Array elements -> arr
 *  Input: Iteration -> Q
 *  Input: Start and End index value -> Start,End
 *
 *  Output: median value
 *
 *  Constraints:
 *  1<= Start <= End <= Array Length
 *
 *  Sample Input:                          |  Output:
 *  Range(R): 6                            |
 *  Array Elements(arr): 6 8 2 11 3 5      |
 *  Iterations(Q): 3                       |
 *  Start and End Index( Start, End): 1 6  |  Median value of sub-array: [2, 3, 5, 6, 8, 11] is: 6
 *  Start and End Index( Start, End): 2 4  |  Median value of sub-array: [2, 8, 11] is: 8
 *  Start and End Index( Start, End): 3 3  |  Median value is: 2
 *
 */
public class FindMedianValue {

    private static void printMedians(int[] generatedArray, int startIndex, int endIndex) {
        if (startIndex >= 1 && startIndex <= endIndex && endIndex <= (generatedArray.length +1) ) {
            if (startIndex == endIndex) {
                System.out.print("Start and End Index is same\n");
                System.out.println("Median value is: " + generatedArray[startIndex-1]);
            }
            else {
                int[] sortedSubArray = Arrays.stream(
                        IntStream.range(startIndex-1, endIndex)
                                .boxed()
                                .mapToInt(item -> generatedArray[item])
                                .toArray()
                ).sorted().toArray();
                int median = sortedSubArray[ (int) Math.ceil(sortedSubArray.length/2)];
                List<Integer> printArrayList = Arrays.stream(sortedSubArray)
                        .mapToObj( elem -> elem )
                        .collect(Collectors.toList());
                System.out.println("Median value of sub-array: " + printArrayList + " is: " + median);
            }
        }
        else {
            throw new RuntimeException("Star and end index should be 1<= start<=end<=array.length");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a range of array: ");
        int range = scanner.nextInt();
        System.out.println("Enter number of iterations: ");
        int iteration = scanner.nextInt();

        System.out.println("Enter array values(space-separated): ");
        int[] generatedArray = ArrayUtility.createArray(scanner, range);
        boolean notNull = ArrayUtility.hasArrayInitialized(generatedArray);
        if (notNull) {
            while (iteration > 0) {
                System.out.println("Provide Start and End Index: ");
                int startIndex = scanner.nextInt();
                int endIndex = scanner.nextInt();
                FindMedianValue.printMedians(generatedArray, startIndex, endIndex);
                iteration--;
            }
        }
        else {
            throw new RuntimeException("Array has not been initialized properly");
        }
    }
}