package ting.leetcode.java.sorting;

public class MinimizeProductSumOfTwoArrays {
    public int minProductSum(int[] nums1, int[] nums2) {
        heapSort(nums1);
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = -nums2[i];
        }
        heapSort(nums2);
        int ans = 0;
        for (int i = 0; i < nums2.length; i++) {
            ans = ans + (nums1[i] * nums2[i] * -1);
        }
        return ans;
    }

    private void heapSort(int[] arr) {
        int heapSize = arr.length;
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapify(arr, heapSize, i);
        }

        for (int i = heapSize - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int heapSize, int rootIndex) {
        int root = rootIndex;
        int left = rootIndex * 2 + 1;
        int right = rootIndex * 2 + 2;

        if (left < heapSize && arr[left] < arr[root]) {
            root = left;
        }

        if (right < heapSize && arr[right] < arr[root]) {
            root = right;
        }

        if (root != rootIndex) {
            swap(arr, rootIndex, root);
            heapify(arr, heapSize, root);
        }
    }

    private void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
