package ting.leetcode.java.sorting;

import java.util.Arrays;

class HeapSort {
    public void heapSort(int[] arr) {
        int heapSize = arr.length;
        // 尋找起始點公式，代表著最後一個「有子節點（可能是左子節點或左右子節點）的父節點」（根節點）的索引。
        int startPoint = arr.length / 2 - 1;

        // 建立 maxHeap （迴圈結束後就確保所有子樹都是最 root node 最大，符合 maxHeap）
        for (int i = startPoint; i >= 0; i--) {
            heapify(arr, heapSize, i);
        }

        // 主要排序，從最後一個子樹開始，把 node 跟整棵樹的 root node 交換
        // 參數 'i' 其實就是代表當前 heap 的大小。
        // 在每一次迴圈的開始，我們會將 'i' 設置爲堆的尺寸。
        // 然後 swap(arr, 0, i) 將 root（索引爲0）和尾節點（索引爲 'i'）互換。
        // 然後，將索引爲 'i' 的元素視爲“已排序”，並不再它再進行 heapify。
        // 我們如何把 i 元素排除的呢？
        // 就是將其直接當成 heapSize 傳入
        // heapify 方法在比較時，會直接忽略大於 heapSize 的 node index
        // 以此達成邏輯上的分割
        for (int i = heapSize - 1; i >= 0; i--) {
            swap(arr, 0, i); // 樹頂是最大值，丟到最後面，不再加入排序。
            heapify(arr, i, 0);
        }
        // 簡言之，上述迴圈在做的事情就是，透過 maxHeap 的特性(root node 必為最大值)
        // 把 root node 丟到陣列尾端，並將其排除在 heapify 作用範圍之外
        // 不斷重複過程就可以取得升序排列的陣列
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

class HeapSortNew {
    public int[] heapSort(int[] nums) {
        // 第一步，原地建堆，注意这里创建的是大顶堆
        // 只要从左往右对每个元素调用 swim 方法，就可以原地建堆
        for (int i = 0; i < nums.length; i++) {
            maxHeapSwim(nums, i);
        }

        // 第二步，排序
        // 现在整个数组已经是一个大顶了，直接模拟删除堆顶元素的过程即可
        int heapSize = nums.length;
        while (heapSize > 0) {
            // 从堆顶删除元素，放到堆的后面
            swap(nums, 0, heapSize - 1);
            heapSize--;
            // 恢复堆的性质
            maxHeapSink(nums, 0, heapSize);
            // 现在 nums[0..heapSize) 是一个大顶堆，nums[heapSize..) 是有序元素
        }
        return nums;
    }

    private void maxHeapSwim(int[] arr, int nodeIndex) {
        // == 0 代表是最根節點，因此不用再 swim
        // maxHeap 的根節點必須最大
        while (nodeIndex > 0 && arr[parent(nodeIndex)] < arr[nodeIndex]) {
            swap(arr, parent(nodeIndex), nodeIndex);
            nodeIndex = parent(nodeIndex);
        }
    }

    private void maxHeapSink(int[] arr, int nodeIndex, int size) {
        while (left(nodeIndex) < size || right(nodeIndex) < size) {
            int max = nodeIndex;
            if (left(nodeIndex) < size && arr[left(nodeIndex)] > arr[max]) {
                max = left(nodeIndex);
            }

            if (right(nodeIndex) < size && arr[right(nodeIndex)] > arr[max]) {
                max = right(nodeIndex);
            }

            if (nodeIndex == max)
                // 沒有改變代表遵守 maxHeap 特性，也就是排序完成
                break;

            swap(arr, max, nodeIndex);
            nodeIndex = max;
        }
    }

    private int parent(int nodeIndex) {
        return (nodeIndex - 1) >> 1;
    }

    private int left(int nodeIndex) {
        return (nodeIndex << 1) + 1;
    }

    private int right(int nodeIndex) {
        return (nodeIndex << 1) + 2;
    }

    private void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 17, 3, 9, 14, 8, 8, 8, 8, 2, 11, 6, 12};
        new HeapSortNew().heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}