package ting.leetcode.java.arrays101;

public class MakeTwoArraysEqualByReversingSubarrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] cache = new int[1001];
        for (int i : target) {
            cache[i]++;
        }

        for (int i : arr) {
            if (--cache[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
