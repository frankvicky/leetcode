package ting.leetcode.java.sorting;

public class SortColors {
    public void sortColors(int[] nums) {
        int low = 0, current = 0, high = nums.length - 1;

        while (current <= high) {
            if (nums[current] == 2) {
                swap(nums, current, high);
                high--;
            } else if (nums[current] == 0) {
                swap(nums, current, low);
                low++;
                current++;
            } else current++;
        }
    }

    public static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
