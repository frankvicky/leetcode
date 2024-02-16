package ting.leetcode.java.arrays101;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        PriorityQueue<Integer> elements = new PriorityQueue<>();
        int count = 0;
        int current = arr[0];
        for (int num : arr) {
            if (current != num) {
                elements.add(count);
                current = num;
                count = 1;
            } else {
                count++;
            }
        }

        elements.add(count);


        int accumulator = 0;
        while (accumulator < k) {
            accumulator += elements.poll();
        }

        if (accumulator == k)
            return elements.size();
        return elements.size() + 1;
    }
}
