package ting.leetcode.java.arrays101;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class DivideArrayIntoArraysWithMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length / 3;
        int[][] ans = new int[n][3];
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                ans[i][j] = nums[3 * i + j];
            }

//            排序後只需要比較最第一個元素和最後一個元素是否超越 k 即可
            if (ans[i][2] - ans[i][0] > k) {
                return new int[][]{};
            }
        }
        return ans;
    }
}
