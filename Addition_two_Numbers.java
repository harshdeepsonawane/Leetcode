// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

 

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]

package Leetcode;
import java.util.Arrays;

class Addition_two_Numbers {
    public int[] twoSum(int[] nums, int target) {
        int[][] numsWithIndices = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numsWithIndices[i][0] = nums[i];  // value
            numsWithIndices[i][1] = i;        // original index
        }

        // Sort based on the values
        Arrays.sort(numsWithIndices, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = numsWithIndices[left][0] + numsWithIndices[right][0];

            if (sum == target) {
                return new int[]{numsWithIndices[left][1], numsWithIndices[right][1]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}