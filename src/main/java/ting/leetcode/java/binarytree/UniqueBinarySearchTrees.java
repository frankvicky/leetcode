package ting.leetcode.java.binarytree;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[][] memo = new int[n][n];
        return count(1, n, memo);
    }

    /**
     * @param low
     * @param high
     * @param memo
     * @return how many unique bst order in close range between low and high
     */
    private int count(int low, int high, int[][] memo) {
        if (low > high)
            return 1;
        if (memo[low][high] != 0)
            return memo[low][high];

        int res = 0;
        for (int i = low; i <= high; i++) {
            int left = count(low, i - 1, memo);
            int right = count(i + 1, high, memo);
            res += left * right;
            memo[low][high] = res;
        }
        return memo[low][high];
    }
}
