package ting.leetcode.java.binarysearch;

import java.net.InetAddress;
import java.net.UnknownHostException;
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

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int leftBound = bs(nums, target, (v1, v2) -> v1 < v2);
        if (leftBound > nums.length || nums[leftBound] != target)
            return ans;

        int rightBound = bs(nums, target, (v1, v2) -> v1 <= v2) - 1;
        ans[0] = leftBound;
        ans[1] = rightBound;
        return ans;
    }

    private int bs(int[] nums, int target, BiPredicate<Integer, Integer> condition) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (condition.test(nums[mid], target)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int bs(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] <= target)
                left = mid + 1;
            else
                right = mid ;

        }

        return left;
    }

    public static void main(String[] args) throws UnknownHostException {
        int[] arr = {2, 3, 5, 4, 6, 7, 9, 8};
        System.out.println(bs(arr, 7));
        System.err.println(InetAddress.getByName("illegal-hostname"));
    }
}
