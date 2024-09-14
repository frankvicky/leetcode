package ting.leetcode.java.sorting;

import java.util.Random;

public class ThreewayQuickSort {
    private final Random random = new Random();

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int[] pivotIndices = partition(arr, left, right);
            quickSort(arr, left, pivotIndices[0] - 1);
            quickSort(arr, pivotIndices[1] + 1, right);
        }
    }

    private int[] partition(int[] arr, int left, int right) {
        int pivotValue = arr[left + random.nextInt(right - left + 1)];
        int lessThan = left; // 小於指針，在該指針之後前的都比 pivotValue 小
        int greaterThan = right; // 大於指針，在該指針之後的都比 pivotValue 大
        int i = left;

        while (i <= greaterThan) {
            if (arr[i] < pivotValue) {
                // 這便使用 i++ 的原因是因為已經確定當下的 arr[i] 已經是比 pivotValue 還小了，所以可以往前推進
                swap(arr, i++, lessThan++);
            } else if (arr[i] > pivotValue) {
                // 這便使用 i 的原因是因為無法確定交換回來的 arr[i] 比 pivotValue 還小，所以可以不可以推進，留給下一輪迴圈檢查
                swap(arr, i, greaterThan--);
            } else {
                i++;
            }
        }

        return new int[]{lessThan, greaterThan};
    }

    private void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 17, 3, 9, 14, 8, 8, 8, 8, 2, 11, 6, 12};
        int[] sorted = new ThreewayQuickSort().sortArray(nums);
        for (int num : sorted) {
            System.out.print(num + " ");
        }
    }
}

class QS {
    private static final Random random = new Random();
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int[] pivots = partition(arr, left, right);
            quickSort(arr, left, pivots[0] - 1);
            quickSort(arr, pivots[1] + 1, right);
        }
    }

    public static int[] partition(int[] arr, int left, int right) {
        int pivot = left + random.nextInt(right - left + 1);
        int lessThan = left;
        int greaterThan = right;
        int pivotValue = arr[pivot];

        int i = left;
        while (i <= greaterThan) {
            if (arr[i] < pivotValue)
                swap(arr, i++, lessThan++);
            else if (arr[i] > pivotValue)
                swap(arr, i, greaterThan--);
            else i++;
        }

        return new int[] {lessThan, greaterThan};
    }

    public static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 17, 8, 9, 14, 8, 3, 8, 6, 2, 11, 8, 12};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
