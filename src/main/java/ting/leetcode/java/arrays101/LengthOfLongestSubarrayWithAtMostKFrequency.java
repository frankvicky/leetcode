package ting.leetcode.java.arrays101;

import java.util.HashMap;

public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0, right = 0, ans = 0;
        HashMap<Integer, Integer> numberToFrequency = new HashMap<>();

        while (right < nums.length) {
            int current = nums[right];
            numberToFrequency.merge(current, 1, (v1, v2) -> ++v1);

            while (left < right && numberToFrequency.get(current) > k) {
                int leftValue = nums[left];
                numberToFrequency.compute(leftValue, (key, val) -> val > 0 ? --val : 0);
                left++;
            }

            ans = Math.max(right - left + 1, ans);
            right++;
        }

        return ans;

    }

    public static void main(String[] args) {
        new LengthOfLongestSubarrayWithAtMostKFrequency()
                .maxSubarrayLength(new int[] {1,2,1,2,1,2,1,2}, 1);
    }
}
