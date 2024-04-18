package ting.leetcode.java.sorting;

public class HeapSort {
    public void heapSort(int[] arr) {
        int heapSize = arr.length;
        // 尋找起始點公式，代表著最後一個有子節點（可能是左子節點或左右子節點）的父節點（根節點）的索引。
        int startPoint = arr.length / 2 - 1;


        // 建立 maxHeap (重新排列 arr)
        for (int i = startPoint; i >= 0; i--) {
            heapify(arr, heapSize, i);
        }

        // 主要排序，從最後一個 node 往頂部逐一維護每個子樹的 maxHeap 特性
        for (int i = heapSize - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);;
        }
    }

    private void heapify(int[] arr, int heapSize, int rootIndex) {
        // 如果 rootIndex 本身就是 leaf node，那不會產生任何改動
        int rootNodeIndex = rootIndex; // root node
        int leftNodeIndex = rootNodeIndex * 2 + 1; // 取得 left node
        int rightNodeIndex = rootNodeIndex * 2 + 2; // 取得 right node

        // 檢查 left node 或 right node是否大於 root node，是則替換
        if (leftNodeIndex < heapSize && arr[leftNodeIndex] > arr[rootNodeIndex]) {
            rootNodeIndex = leftNodeIndex;
        }

        if (rightNodeIndex < heapSize && arr[rightNodeIndex] > arr[rootNodeIndex]) {
            rootNodeIndex = rightNodeIndex;
        }

        // 如果 rootNodeIndex 不是原來的 rootIndex
        // 代表還沒找到 maxHeap 的根結點（不管是子樹還是整棵樹）
        // 交換之後再次執行 heapify，直到找到為止
        if (rootNodeIndex != rootIndex) {
            swap(arr, rootIndex, rootNodeIndex);
            heapify(arr, heapSize, rootNodeIndex);
        }
    }

    private void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
