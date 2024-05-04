package ting.leetcode.java.binarysearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid ;
        }

        return left < nums.length && nums[left] == target ? left : -1;
    }
}
