package ting.leetcode.java.arrays101;

public class MinimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return -1;
        }

        int p1 = 0;
        int p2 = 0;

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums2[p2] < nums1[p1]) {
                p2++;
            } else if (nums2[p2] > nums1[p1]) {
                p1++;
            } else {
                return nums2[p2];
            }
        }

        return -1;
    }
}
