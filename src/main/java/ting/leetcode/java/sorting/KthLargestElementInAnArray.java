package ting.leetcode.java.sorting;

import java.util.Random;

public class KthLargestElementInAnArray {
    private final Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high) {
            return arr[low];
        }

        int randomPivotIndex = low + random.nextInt(high - low + 1);
        swap(arr, high, randomPivotIndex);
        int pivotIndex = partition(arr, low, high);

        if (pivotIndex == k) {
            return arr[pivotIndex];
        } else if (pivotIndex > k) {
            return quickSelect(arr, low, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, high, k);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivotValue = arr[high];
        int i = low - 1;

        for (int j = low; j < high; ++j) {
            if (arr[j] < pivotValue) {
                ++i;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
