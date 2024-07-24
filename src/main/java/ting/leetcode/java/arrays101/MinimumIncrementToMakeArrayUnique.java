package ting.leetcode.java.arrays101;

import java.util.Arrays;

// 理想狀況下，最小增量就是陣列中所有元素剛好都只差 1，因此可以用排序來解題
public class MinimumIncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        // 這個變數代表陣列中第 i 個元素，應該也要是第 i + 1 小的值
        int shouldBe = -1;
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (shouldBe >= nums[i]) {
                ans += (shouldBe - nums[i]) + 1;
                nums[i] = shouldBe + 1;
            }
            shouldBe = nums[i];
        }
        return ans;
    }
}