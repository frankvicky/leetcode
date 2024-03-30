package ting.leetcode.java.binarysearch;

import java.util.function.BiPredicate;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums.length == 0) {
            return ans;
        }

        int firstElement = binarySearchLeft(nums, target);

        if (firstElement >= nums.length || nums[firstElement] != target) {
            return ans;
        }

        ans[0] = firstElement;

        int left = binarySearchRight(nums, target);

        ans[1] = left - 1;
        return ans;
    }

    private static int binarySearchLeft(int[] nums, int target) {
        return bs(nums, target, (v1, v2) -> v1 < v2);
    }

    private static int binarySearchRight(int[] nums, int target) {
        return bs(nums, target, (v1, v2) -> v1 <= v2);
    }

    private static int bs(int[] nums, int target, BiPredicate<Integer, Integer> predicate) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (predicate.test(nums[mid], target)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
