package ting.leetcode.java.slidingwindow;

import java.util.ArrayDeque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>(); // 存儲索引

        for (int i = 0; i < nums.length; i++) {
            // 移除超出窗口範圍的元素
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.pollFirst();
            }

            // 維護遞減序列：移除所有小於當前元素的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 添加當前元素的索引
            deque.offerLast(i);

            // 當窗口大小達到k時，記錄最大值
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}
