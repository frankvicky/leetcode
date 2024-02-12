package ting.leetcode.java.arrays101;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElementTwoPointer(int[] nums) {
        Arrays.sort(nums);

        int maxCount = 0;
        int majorElement = 0;
        int slow = 0, fast = 0;

        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                int streak = fast - slow;
                if (streak > maxCount) {
                    maxCount = streak;
                    majorElement = nums[slow];
                    slow = fast;
                }
            }
            fast++;
        }
        return fast - slow > maxCount ? nums[fast - 1] : majorElement;
    }
    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = 0;
        for (int num : nums) {
            if (count == 0) {
                ans = num;
            }
            count += (ans == num) ? 1 : -1;
        }
        return ans;
    }
}
