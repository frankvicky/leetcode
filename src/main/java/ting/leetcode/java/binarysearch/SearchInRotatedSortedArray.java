package ting.leetcode.java.binarysearch;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // 第一步，找到旋转的索引
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // left就是旋转的索引，也是峰值的位置
        int rotateIndex = left;
        // 重置left 和 right
        left = 0;
        right = nums.length - 1;

        // 判断目标值在那个部分
        if (target >= nums[rotateIndex] && target <= nums[right]) {
            left = rotateIndex;  // 如果在后半部分，修改左边界
        } else {
            right = rotateIndex; // 如果在前半部分，修改右边界
        }

        // 开始二分查找
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
