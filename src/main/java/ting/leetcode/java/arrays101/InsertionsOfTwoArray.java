package ting.leetcode.java.arrays101;

import java.util.HashSet;

public class InsertionsOfTwoArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();

        for (int i : nums1) {
            s1.add(i);
        }

        for (int i : nums2) {
            if (s1.contains(i))
                s2.add(i);
        }

        int[] ans = new int[s2.size()];
        int index = 0;
        for (int i : s2) {
            ans[index++] = i;
        }
        return ans;
    }
}
