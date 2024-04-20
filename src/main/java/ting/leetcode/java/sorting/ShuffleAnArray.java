package ting.leetcode.java.sorting;

import java.util.Random;

public class ShuffleAnArray {
}

class Solution {
    private final Random random;
    private final int[] originalArray;

    public Solution(int[] nums) {
        random = new Random();
        originalArray = nums;
    }

    public int[] reset() {
        return originalArray;
    }

    public int[] shuffle() {
        int[] shuffled = new int[originalArray.length];

        for (int i = 0; i < shuffled.length; i++) {
            shuffled[i] = i;
            int next = random.nextInt(i + 1);
            swap(shuffled, next, i);
        }

        for (int i = 0; i < shuffled.length; i++) {
            shuffled[i] = originalArray[shuffled[i]];
        }

        return shuffled;
    }

    private void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}