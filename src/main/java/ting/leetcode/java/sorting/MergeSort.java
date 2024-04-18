package ting.leetcode.java.sorting;

public class MergeSort {
    // MergeSort 的實作並不會真的二分集合然後用新集合去裝，這樣太浪費空間，而是進行邏輯上的二分
    // 參數 cache 用於儲存排序結果
    public void mergeSort(int[] arr, int left, int right, int[] cache) {
        if (left < right) {
            int mid = (right - left) / 2 + left;
            mergeSort(arr, left, mid, cache);
            mergeSort(arr, mid + 1, right, cache);
            merge(arr, left, mid, right, cache);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] cache) {
        int leftArrayIndex = left;
        int rightArrayIndex = mid + 1;
        int cacheIndex = 0;
        int originalArrayIndex = left;

        // 遍歷左右集合，較小的優先加入 cache
        while (leftArrayIndex <= mid && rightArrayIndex <= right) {
            if (arr[leftArrayIndex] <= arr[rightArrayIndex]) {
                cache[cacheIndex] = arr[leftArrayIndex];
                leftArrayIndex++;
            } else {
                cache[cacheIndex] = arr[rightArrayIndex];
                rightArrayIndex++;
            }
            cacheIndex++;
        }

        // 左或右側集合遍歷完畢，讓剩餘的元素直接加入 cache
        while (leftArrayIndex <= mid) {
            cache[cacheIndex] = arr[leftArrayIndex];
            cacheIndex++;
            leftArrayIndex++;
        }

        while (rightArrayIndex <= right) {
            cache[cacheIndex] = arr[rightArrayIndex];
            cacheIndex++;
            rightArrayIndex++;
        }

        cacheIndex = 0;

        // cache 儲存了排序結果，最後回填給原始陣列
        while (originalArrayIndex <= right) {
            arr[originalArrayIndex] = cache[cacheIndex];
            originalArrayIndex++;
            cacheIndex++;
        }
    }
}
