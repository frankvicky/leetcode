package ting.leetcode.java.arrays101;

import java.util.Arrays;

public class RangeSumOfSortedSubarraySums {
    public static int rangeSum(int[] nums, int n, int left, int right) {
        int mod = 1_000_000_007;
        int size = (n * (n + 1)) >> 1;
        int[] arr = new int[size];

        int index = 0;  // 用一個單一的索引來處理 arr 的填充
        // 計算所有子陣列的和
        for (int i = 0; i < n; i++) {
            int acc = 0;
            for (int j = i; j < n; j++) {
                acc += nums[j];
                arr[index++] = acc;  // 將累加的和加入 arr，並遞增索引
            }
        }

        Arrays.sort(arr);  // 對數組進行排序

        int result = 0;
        // 從 left 到 right 的索引範圍內進行求和
        for (int i = left - 1; i < right; i++) {
            result = (result + arr[i]) % mod;  // 使用模數來防止溢位
        }

        return result;
    }
}
