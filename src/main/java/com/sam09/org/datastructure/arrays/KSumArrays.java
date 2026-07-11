/**
 * 18. 4Sum
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */

package com.sam09.org.datastructure.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class KSumArrays {

    private int length = 0;

    private List<List<Integer>> kSums(int[] nums, long target, int k, int start) {
        if (start >= this.length) {
            return List.of();
        }

        // Pruning clause
        var minPossible = (long) nums[start] * k;
        var maxPossible = (long) nums[this.length - 1] * k;

        if (target < minPossible || target > maxPossible) {
            return List.of();
        }

        var result = new ArrayList<List<Integer>>();

        if (k == 2) { // Two-Sum approach
            var left = start;
            var right = this.length - 1;
            while (left < right) {
                var sum = (long) nums[left] + nums[right];

                if (sum == target) {
                    var temp = new ArrayList<Integer>();
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        } else {
            for (var currentIndex = start; currentIndex < this.length - 1; currentIndex++) {
                var tempResult = this.kSums(nums, target - nums[currentIndex], k -1, currentIndex + 1);
                if (!tempResult.isEmpty()) {
                    for (var temp : tempResult) {
                        temp.add(0, nums[currentIndex]);
                    }
                    result.addAll(tempResult);
                }

                // Avoid duplicates
                while (currentIndex < this.length - 1 && nums[currentIndex] == nums[currentIndex + 1]) {
                    currentIndex++;
                }
            }
        }

        return result;
    }

    public List<List<Integer>> fourSumArrays(int[] nums, int target) {
        this.length = nums.length;
        if (this.length == 0 || this.length < 4) {
            return List.of();
        }
        Arrays.sort(nums);
        return this.kSums(nums, target, 4, 0);
    }

    public static void main(String[] args) {
        // [1,0,-1,0,-2,2]
        var nums = IntStream.of(1, 0, -1, 0, -2, 2).toArray();
        var obj = new KSumArrays();
        var resultantArray = obj.fourSumArrays(nums, 0);
        System.out.printf("Resultant 4Sum Array of %s is as follows: \n%s" , Arrays.toString(nums), resultantArray.toString());
    }
}
