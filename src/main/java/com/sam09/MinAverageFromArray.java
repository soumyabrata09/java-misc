/**
 * You have an array of floating point numbers averages which is initially empty. You are given an array nums of n integers where n is even.
 *
 * You repeat the following procedure n / 2 times:
 *
 * Remove the smallest element, minElement, and the largest element maxElement, from nums.
 * Add (minElement + maxElement) / 2 to averages.
 * Return the minimum element in averages.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [7,8,3,4,15,13,4,1]
 *
 * Output: 5.5
 *
 * Explanation:
 *
 * step	nums	averages
 * 0	[7,8,3,4,15,13,4,1]	[]
 * 1	[7,8,3,4,13,4]	[8]
 * 2	[7,8,4,4]	[8,8]
 * 3	[7,4]	[8,8,6]
 * 4	[]	[8,8,6,5.5]
 * The smallest element of averages, 5.5, is returned.
 * Example 2:
 *
 * Input: nums = [1,9,8,3,10,5]
 *
 * Output: 5.5
 *
 * Explanation:
 *
 * step	nums	averages
 * 0	[1,9,8,3,10,5]	[]
 * 1	[9,8,3,5]	[5.5]
 * 2	[8,5]	[5.5,6]
 * 3	[]	[5.5,6,6.5]
 * Example 3:
 *
 * Input: nums = [1,2,3,7,8,9]
 *
 * Output: 5.0
 *
 * Explanation:
 *
 * step	nums	averages
 * 0	[1,2,3,7,8,9]	[]
 * 1	[2,3,7,8]	[5]
 * 2	[3,7]	[5,5]
 * 3	[]	[5,5,5]
 *
 *
 * Constraints:
 *
 * 2 <= n == nums.length <= 50
 * n is even.
 * 1 <= nums[i] <= 50
 */

package com.sam09;

import com.sam09.misc.utils.ArrayUtility;

import java.util.*;

public class MinAverageFromArray {

    static double findMinAvg(int[] arr) {
        List<Integer> numList = new ArrayList<>();
        List<Double> average = new ArrayList<>();
        Arrays.stream(arr).forEach(numList::add);
        Collections.sort(numList);
        while (numList.size() > 1) {
            int smallest = numList.removeFirst();
            int largest = numList.removeLast();
            double avg = (smallest + largest) / 2.0;
            average.add(avg);
        }
        return Collections.min(average);
    }

    void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter the range of the array: ");
        var range = scanner.nextInt();
        var arr = ArrayUtility.createArray(scanner, range);
        var minValueAvgValue = MinAverageFromArray.findMinAvg(arr);
        System.out.print("Minimum Average Value: " + minValueAvgValue);
    }
}
