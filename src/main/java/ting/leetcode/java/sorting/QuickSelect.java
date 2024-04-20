package ting.leetcode.java.sorting;

import java.util.Random;

// QuickSelect 用來幫我們快速找出一個集合中第 k 小的元素，並且保證 k 之前的元素都小於第 k 個元素，透過分治法減少完全排序的時間
class QuickSelect {
    // 用來隨機取得 pivotIndex，避免固定 pivotIndex 造成最壞情況
    private final Random random = new Random();
    public void quickSelect(int[] arr, int low, int high, int k) {
        if (low > high) {
            return;
        }

        // 隨機化 pivotIndex
        int randomPivotIndex = low + random.nextInt(high - low + 1);
        swap(arr, high, randomPivotIndex);

        int pivotIndex = partition(arr, low, high);

        if (k == pivotIndex)
            return;
        else if (pivotIndex > k)
            // 尋找到的 pivotIndex 比要求的 k 還大，所以往左尋找
            quickSelect(arr, low, pivotIndex - 1, k);
        else
            // 尋找到的 pivotIndex 比要求的 k 還小，所以往右尋找
            quickSelect(arr, pivotIndex + 1, high, k);
    }

    private int partition(int[] arr, int low, int high) {
        // 選擇 array 中的 high 索引的值為 pivotValue（基准值）
        int pivotValue = arr[high]; // 以 high 為 pivot
        // slow 指針在最初位於序列的左邊界 low - 1，slow 負責追蹤最新的已經處理過並且比 pivot 小的元素的位置。
        int slow = low - 1;

        // fast 指針則用來從 low 開始遍歷整個陣列，fast 尋找的是比 pivot 小的元素。
        for (int fast = low; fast < high; fast++) {
            // arr[fast] 比 pivot 小，我們就將 slow 向右移動一位（slow++），然後交換 arr[slow] 和 arr[fast] 的值。
            if (arr[fast] < pivotValue) {
                slow++;
                swap(arr, slow, fast);
            }
            // 如果 arr[fast] 不小於 pivot，那麼我們就直接將 j 向右移動一位，繼續下一次迴圈。
        }

        // 回圈結束後，這樣的操作確保了 slow 左邊（包括i）的所有元素都不大於 pivotValue
        // 交換 slow + 1 和 high 的值，此時 pivotValue 已到其應在的位置
        // 且左邊的所有值都小於它，右邊的所有值都大於它
        slow++;
        swap(arr, slow, high);
        return slow;
    }

    private void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
