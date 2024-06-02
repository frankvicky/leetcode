package ting.leetcode.java.arrays101;

public class LargestLocalValuesInAMatrix {
    public int[][] largestLocal(int[][] grid) {
        int length = grid.length;
        int[][] ans = new int[length - 2][length - 2];

        // 控制 row 推進
        for (int i = 0; i < length - 2; ++i) {
            // 控制 column 推進
            for (int j = 0; j < length - 2; ++j) {
                // 3 * 3 循環
                for (int k = i; k < i + 3; ++k) {
                    for (int l = j; l < j + 3; ++l) {
                        ans[i][j] = Math.max(ans[i][j], grid[k][l]);
                    }
                }
            }
        }

        return ans;
    }
}
