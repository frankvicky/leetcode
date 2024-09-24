package ting.leetcode.java.linkedlist;

import java.util.*;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0] + o[1]));
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            // [nums1 element, nums2 element, nums2 index]
            pq.offer(new int[] {nums1[i], nums2[0], 0});
        }

        while (!pq.isEmpty() && k > 0) {
            int[] poll = pq.poll();
            res.add(List.of(poll[0], poll[1]));
            int nextNums2Index = poll[2];
            if (nextNums2Index < nums2.length - 1) {
                nextNums2Index++;
                pq.offer(new int[] {poll[0], nums2[nextNums2Index], nextNums2Index});
            }
            k--;
        }
        return res;
    }
}
