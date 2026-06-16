/**
 * Product of Array Except Self
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
package com.sam09.org.datastructure.arrays;

import com.sam09.misc.utils.ArrayUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProductArrayExceptSelf {

    public static final Logger log = LoggerFactory.getLogger(ProductArrayExceptSelf.class);

    static int[] getProductArrayExceptSelf(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{ };
        }
        var list = new ArrayList<Integer>();
        for (var i = 0; i < arr.length; i++) {
            var j = i+1;
            var k = i-1;
            var prefixProduct = 1;
            var suffuiProduct = 1;
            while (j < arr.length) {
                suffuiProduct *= arr[j];
                j++;
            }
            while (k >= 0) {
                prefixProduct *= arr[k];
                k--;
            }

            list.add(prefixProduct * suffuiProduct);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main (String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Enter array size: ");
        var range = scanner.nextInt();
        System.out.println("Enter the array values: ");
        var arr = ArrayUtility.createArray(scanner, range);
        var result = ProductArrayExceptSelf.getProductArrayExceptSelf(arr);
        log.info("Product Array of {} is {}", Arrays.toString(arr), Arrays.toString(result));
    }
}
