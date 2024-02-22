package ting.leetcode.java.arrays101;

public class FindTheTwoJudge {
    public int findJudge(int n, int[][] trust) {
        int[] trustPoint = new int[n + 1];

        for (int[] t : trust) {
            trustPoint[t[0]]--;
            trustPoint[t[1]]++;
        }
        for (int j = 1; j < trustPoint.length; j++) {
            if (trustPoint[j] == n - 1)
                return j;
        }
        return -1;
    }
}
