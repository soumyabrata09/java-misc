/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */

package com.sam09.org.datastructure.arrays;

import java.util.ArrayList;
import java.util.List;

public class ThreeSumArray {

    List<List<Integer>> getThreeSumTuples(int[] nums) {
        if (nums.length < 0) {
            return List.of();
        }

        var list = new ArrayList<List<Integer>>();

        for (var i = 0; i < nums.length; i++) {
            var left = i + 1;
            var right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            while (left < right) {
                var sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    list.add(List.of(
                            nums[i], nums[left], nums[right]
                    ));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return list;
    }

    public static void main (String args[]) {
        var obj = new ThreeSumArray();
        var result = obj.getThreeSumTuples(new int[]{-1, 2, 1, -4, 0, -1});
        System.out.println(result);
    }
}
