package ting.leetcode.java.sorting;

public class QuickSort {
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // QuickSort 的核心，透過指定(或找到)一個 pivotIndex 做為要固定的支點和分治法的邊界
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        // 選擇 array 中的 high 索引的值為 pivotValue（基准值）
        int pivotValue = arr[high];
        // i 指針在最初位於序列的左邊界 low - 1，i 負責追蹤最新的已經處理過並且比 pivot 小的元素的位置。
        int i = low - 1;

        // j 指針則用來從 low 開始遍歷整個陣列，j 尋找的是比 pivot 小的元素。
        for (int j = low; j < high; ++j) {
            // arr[j] 比 pivot 小，我們就將 i 向右移動一位（i++），然後交換 arr[i] 和 arr[j] 的值。
            if (arr[j] < pivotValue) {
                ++i;
                swap(arr, i, j);
            }
            // 如果 arr[j] 不小於 pivot，那麼我們就直接將 j 向右移動一位，繼續下一次迴圈。
        }

        // 回圈結束後，這樣的操作確保了 i 左邊（包括i）的所有元素都不大於 pivot，
        // 交換 i + 1 和 high 的值，此時基准值已到其應在的位置
        // 且左邊的所有值都小於它，右邊的所有值都大於它
        swap(arr, i + 1, high);

        return i + 1;
    }

    private void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
