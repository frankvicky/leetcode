package ting.leetcode.java.arrays101;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < matrix.length; i++) {
            // [head, outer-index, inner-index]
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        int res = -1;
        while (!pq.isEmpty() && k > 0) {
            int[] current = pq.poll();
            res = current[0];
            k--;

            int i = current[1], j = current[2];
            if (j + 1 < matrix[i].length) {
                pq.offer(new int[]{matrix[i][j + 1], i, j + 1});
            }
        }
        return res;
    }
}
