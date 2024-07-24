package ting.leetcode.java.arrays101;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public int minDifference(int[] nums) {
        int length = nums.length;
        if (length <= 4) {
            return 0;
        }

        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            result = Math.min(nums[i + 1] - nums[i], result);
        }

        return result;
    }
}
