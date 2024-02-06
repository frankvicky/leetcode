package ting.leetcode.java.arrays101;

import java.util.Arrays;
import java.util.TreeSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int longest = 0;
        int count = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i])
                continue;

            if (nums[i + 1] - nums[i] == 1)
                count++;
            else {
                longest = Math.max(longest, count);
                count = 1;
            }
        }
        return Math.max(longest, count);
    }

    public static void main(String[] args) {
        int[] a = {0,3,7,2,5,8,4,6,0,1};
        new LongestConsecutiveSequence()
                .longestConsecutive(a);
    }
}
