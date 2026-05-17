/**
 * You are given an array height where each element represents the height of a vertical line positioned at that index on the x-axis. In other words, the line at index i spans from the point (i, 0) up to (i, height[i]).
 * our task is to choose two different lines such that, together with the x-axis, they form a container that holds the maximum possible water.
 * Example 1:
 *
 * Input: height = [2,9,1,4,7,8]
 * Output: 32
 * Explanation: Choosing the lines at index 1 (height 9) and index 5 (height 8) gives:
 * Distance: 5 - 1 = 4
 * Minimum height: min(9, 8) = 8
 * Water contained: 4 * 8 = 32
 * Constraints:
 * The length of the array height is at least 2.
 * Each element in height is a non-negative integer.
 */

package com.sam09.Exercises;

public class MaximumWaterContainer {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;

        while (left < right) {
            result = Math.max(
                    result,
                    Math.min(height[left], height[right]) * (right - left)
            );

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        var maxWaterContainer = new MaximumWaterContainer();
        var height = new int[] {2,9,1,4,7,8};
        System.out.println("Maximum water container area: " + maxWaterContainer.maxArea(height));
    }
}
