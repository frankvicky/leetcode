package ting.leetcode.java.sorting;

import java.util.Arrays;
import java.util.Random;

public class SortPlayground {
    private static final Random random = new Random();
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        while (n > 0) {
            // lastSwapIndex 记录了最后一次元素交换的位置。因为在此之后的元素已经有序，下一轮排序可以不再考虑这些元素，从而提高算法效率。
            int lastSwapIndex = 0;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    lastSwapIndex = i + 1;
                }
            }
            // 在内层循环结束后，将 n 更新为 lastSwapIndex。
            // 这样做是因为在 lastSwapIndex 之后的元素已经是有序的，不需要再进行比较和交换。
            n = lastSwapIndex;
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int randomPivotIndex = left + random.nextInt(right - left + 1);
            swap(arr, left, randomPivotIndex);
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, pivotIndex + 1, right);
            quickSort(arr, left, pivotIndex -1);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotValue = arr[right];
        int slow = left - 1;
        for (int fast = left; fast < right; fast++) {
            if (arr[fast] < pivotValue)
                swap(arr, ++slow, fast);
        }
        swap(arr, ++slow, right);
        return slow;
    }

    private static void threePivotQuickSort(int[] arr, int left, int right) {
        if (left < right) {
            int[] partitions = threePivotPartition(arr, left, right);
            threePivotQuickSort(arr, left, partitions[1] - 1);
            threePivotQuickSort(arr, partitions[0] + 1, right);
        }
    }

    private static int[] threePivotPartition(int[] arr, int left, int right) {
        int pivotValue = arr[left + random.nextInt(right - left + 1)];
        int lessThan = left;
        int greaterThan = right;
        int i = left;

        while (i <= greaterThan) {
            if (arr[i] < pivotValue) {
               swap(arr, i++, lessThan++);
            } else if (arr[i] > pivotValue) {
                swap(arr, i, greaterThan--);
            } else i++;
        }
        return new int[] {lessThan, greaterThan};
    }

    private static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    private static int quickSelect(int[] arr, int left, int right, int kth) /*kth here is 0-based*/ {
        if (left > right) {
            return -1;
        }
        int randomPivotIndex = left + random.nextInt(right - left + 1);
        swap(arr, left, randomPivotIndex);
        int pivotIndex = partition(arr, left, right);
        if (pivotIndex == kth)
            return arr[pivotIndex];
        else if (pivotIndex < kth)
            return quickSelect(arr, pivotIndex + 1, right, kth);
        else
            return quickSelect(arr, left, pivotIndex - 1, kth);
    }

    public static void heapSort(int[] arr) {
        int heapSize = arr.length;
        int lastRootNodeIndex = (arr.length >> 1) - 1;
        for (int i = lastRootNodeIndex; i >= 0; i--) {
            heapify(arr, i, heapSize);
        }

        for (int i = heapSize - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    private static void heapify(int[] arr, int rootIndex, int heapSize) {
        int root = rootIndex;
        int left = (root << 1) + 1;
        int right = (root << 1) + 2;

        if (left < heapSize && arr[left] > arr[root])
            root = left;

        if (right < heapSize && arr[right] > arr[root])
            root = right;

        if (root != rootIndex) {
            swap(arr, root, rootIndex);
            heapify(arr, root, heapSize);
        }
    }

    public static void mergeSort(int[] arr, int left, int right, int[] cache) {
        if (left < right) {
            int mid = ((right - left) >> 1) + left;
            mergeSort(arr, left, mid, cache);
            mergeSort(arr, mid + 1, right, cache);
            merge(arr, left, mid, right, cache);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] cache) {
        int leftArrayIndex = left;
        int rightArrayIndex = mid + 1;
        int cacheIndex = 0;
        int originalArrayIndex = left;

        while (leftArrayIndex <= mid && rightArrayIndex <= right) {
            if (arr[leftArrayIndex] < arr[rightArrayIndex]) {
                cache[cacheIndex] = arr[leftArrayIndex++];
            } else {
                cache[cacheIndex] = arr[rightArrayIndex++];
            }
            cacheIndex++;
        }

        while (leftArrayIndex <= mid)
            cache[cacheIndex++] = arr[leftArrayIndex++];

        while (rightArrayIndex <= right)
            cache[cacheIndex++] = arr[rightArrayIndex++];

        cacheIndex = 0;
        while (originalArrayIndex <= right)
            arr[originalArrayIndex++] = cache[cacheIndex++];
    }

    public static int bs(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int bsb(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {5, 17, 3, 9, 14, 8, 8, 8, 8, 2, 11, 6, 12};
        Arrays.sort(arr);
        int[] arr1 = {5, 17, 3, 9, 14, 8, 8, 8, 8, 2, 11, 6, 12};
        quickSort(arr1, 0, arr.length - 1);
        int[] arr2 = {5, 17, 3, 9, 14, 8, 8, 8, 8, 2, 11, 6, 12};
        heapSort(arr2);
        int[] arr3 = {5, 17, 3, 9, 14, 8, 8, 8, 8, 2, 11, 6, 12};
        mergeSort(arr3, 0, arr.length - 1, new int[arr3.length]);
        int[] arr4 = {5, 17, 3, 9, 14, 8, 8, 8, 8, 2, 11, 6, 12};
        bubbleSort(arr4);
        int[] arr6 = {5, 17, 3, 9, 14, 8, 8, 8, 8, 2, 11, 6, 12};
        threePivotQuickSort(arr6, 0, arr.length - 1);
        Arrays.stream(arr).forEach(i -> System.err.print(i + " "));
        System.err.print(" : Built-in");
        System.err.println();
        Arrays.stream(arr1).forEach(i -> System.err.print(i + " "));
        System.err.print(" : QuickSort");
        System.err.println();
        Arrays.stream(arr2).forEach(i -> System.err.print(i + " "));
        System.err.print(" : HeapSort");
        System.err.println();
        Arrays.stream(arr3).forEach(i -> System.err.print(i + " "));
        System.err.print(" : MergeSort");
        System.err.println();
        Arrays.stream(arr4).forEach(i -> System.err.print(i + " "));
        System.err.print(" : BubbleSort");
        System.err.println();
        Arrays.stream(arr6).forEach(i -> System.err.print(i + " "));
        System.err.print(" : Three-pivot QuickSort");
        System.err.println();
        System.err.println("Quick Select");
        System.err.println(quickSelect(arr, 0, arr.length - 1, 0));
        System.err.println(quickSelect(arr, 0, arr.length - 1, 4));
        System.err.println(quickSelect(arr, 0, arr.length - 1, 6));
        System.err.println(quickSelect(arr, 0, arr.length - 1, 8));
        System.err.println(quickSelect(arr, 0, arr.length - 1, 12));


        int[] arr5 = {5, 17, 3, 9, 14, 8, 8, 8, 8, 2, 11, 6, 12};
        Arrays.sort(arr5);
        Arrays.stream(arr5).forEach(i -> System.err.print(i + " "));
        System.err.println();
        System.err.println("Binary Search");
        System.err.println(bs(arr5, 2));
        System.err.println(bs(arr5, 6));
        System.err.println(bs(arr5, 8));
        System.err.println(bs(arr5, 9));
        System.err.println(bs(arr5, 17));

        Arrays.stream(arr5).forEach(i -> System.err.print(i + " "));
        System.err.println();
        System.err.println("Binary Search Border");
        System.err.println(bsb(arr5, 2));
        System.err.println(bsb(arr5, 6));
        System.err.println(bsb(arr5, 8));
        System.err.println(bsb(arr5, 9));
        System.err.println(bsb(arr5, 17));
    }
}

