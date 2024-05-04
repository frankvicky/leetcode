package ting.leetcode.java.queueandstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {
    // 該算法主要是透過索引的特性去追蹤窗口大小
    // 由 ArrayDequeue 去儲存管理索引
    // for 迴圈中主要是迭代給定陣列
    // 第一個 while 透過(index - k + 1)去計算明 窗口 (Deque)大小，如果 窗口 (Deque)頂部索引值如果小於(index - k + 1)，說明頂部索引值已經超出窗口，所以 pop 掉
    // 第二個 while 是讓 窗口 (Deque) 頂部永遠是最大元素的索引
    // 為什麼如果當下索引所代表的元素比 窗口 (Deque) 中的元素大就可以一直 pop？ 因為如果在窗口中不是最大元素，以後也不會是，所以直接 pop，還有第一個 while 會維護窗口滑動。
    // 維護好窗口大小和確定最大元素後，繼續把索引值放入 Deque
    // 最後一個 if 表示，如果頂部索引值跟窗口長度一樣或大於，說明 窗口 (Deque)已經填滿，可以開始把頂部索引所代表的元素(也就是當下窗口的最大元素)加入 ans 陣列。
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 創建一個額外的數組用來存儲每個滑動窗口的最大值
        int[] ans = new int[nums.length - k + 1];

        // 使用一個雙端隊列 Deque 來存儲滑動窗口中的元素的索引值，將最大的始終存放在隊首
        Deque<Integer> queue = new ArrayDeque<>(k);

        // 遍歷輸入的整數數組nums[]
        for (int i = 0; i < nums.length; i++) {
            // 當隊首元素的索引值超出滑動窗口範圍時，將其從隊列中移除
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.pop();
            }

            // 如果新的元素比上一個元素大，則將上一個元素從隊列中刪除
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            // 否則，將新的元素索引添加到隊列的末尾
            queue.offer(i);

            // 如果遍歷的元素數目已經超過k，那即可提取每個窗口的最大值至結果數組
            if (i >= k - 1) {
                // 隊列頭部元素就是本窗口最大值的索引
                ans[i - k + 1] = nums[queue.peek()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        new MaxSlidingWindow().maxSlidingWindow(arr, 3);
    }
}
