package ting.leetcode.java.arrays101;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> differenceToIndex = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            int difference = target - element;
            if (differenceToIndex.containsKey(element)){
                return new int[] {differenceToIndex.get(element), i};
            }
            differenceToIndex.put(difference, i);
        }
        return result;
    }
}
