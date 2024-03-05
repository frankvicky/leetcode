package ting.leetcode.java.arrays101;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {
    public int minimumLength(String s) {
        char[] sArray = s.toCharArray();
        int left = 0;
        int right = sArray.length - 1;

        while (left < right) {
            if (sArray[left] != sArray[right]) {
                break;
            }

            char streakChar = sArray[left];
            while (sArray[left] == streakChar && left < right) {
                ++left;
            }
            while (sArray[right] == streakChar && left <= right) {
                --right;
            }
        }
        return right - left + 1;
    }
}
