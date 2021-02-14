package com.example.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

    }
    public int[] twoSum(int[] nums, int target) {
        if(!valid(nums, target)) {
            throw new RuntimeException("parameter is not valid");
        }
        Map<Integer, Integer> integerStore = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int val = nums[i];
            integerStore.put(val, i);
        }

        for(int i=0;i<nums.length;i++) {
            int val = nums[i];
            int x = target - val;
            if(integerStore.containsKey(x) && integerStore.get(x) !=i) {
                return new int[]{i, integerStore.get(x)};
            }
        }
        return null;
    }

    private boolean valid(int[] nums, int target) {
        if(nums == null || !(2 <= nums.length && nums.length <= 1000)) {
            return false;
        }
        if(over109(target)) {
            return false;
        }
        for(int num : nums) {
            if(over109(num)) {
                return false;
            }
        }
        return true;
    }

    private boolean over109(int integer) {
        if(Math.abs(integer) > 1000000000) {
            return true;
        }
        return false;
    }
}
