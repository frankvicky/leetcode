package ting.leetcode.java.arrays101;

import java.util.Arrays;

public class FindPolygonWithTheLargestPerimeter {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        long[] prefixSum = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            int prefixSumPointer = i + 1;
            prefixSum[prefixSumPointer] = nums[i] + prefixSum[prefixSumPointer - 1];
        }

        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < prefixSum[i]) {
                return prefixSum[i + 1];
            }
        }

        return -1;
    }

    public long largestPerimeter2(int[] nums) {
        Arrays.sort(nums);
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        prefixSum[1] = nums[0] + nums[1];
        long ans = -1;
        for (int i = 2; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
            if (prefixSum[i - 1] > nums[i]) {
                ans = prefixSum[i];
            }
        }
        return ans;
    }
}
