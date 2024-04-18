package ting.leetcode.java.arrays101;

public class IslandPerimeter {
        public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (i < 1 || grid[i - 1][j] == 0)
                        sum++;
                    if (i > grid.length - 2 || grid[i + 1][j] == 0) {
                        sum++;
                    }
                    if (j < 1 || grid[i][j - 1] == 0) {
                        sum++;
                    }
                    if (j > grid[i].length - 2 || grid[i][j + 1] == 0) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
}
