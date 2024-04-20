package ting.leetcode.java.arrays101;

import java.util.ArrayList;
import java.util.List;

public class FindAllGroupsOfFarmland {
    public int[][] findFarmland(int[][] land) {
        List<int[]> cache = new ArrayList<>();
        for (int row = 0; row < land.length; row++) {
            for (int column = 0; column < land[row].length; column++) {
                if (land[row][column] == 1) {
                    int[] group = new int[4];
                    group[0] = row;
                    group[1] = column;
                    cache.add(dfs(land, row, column, group));
                }
            }
        }

        return cache.toArray(new int[cache.size()][]);
    }

    private int[] dfs(int[][] grid, int row, int column, int[] group) {
        if (row < 0 || column < 0 || row > grid.length - 1 || column > grid[row].length - 1 || grid[row][column] == 0) {
            return new int[4];
        }


        grid[row][column] = 0;
        group[2] = Math.max(group[2], row); // 更新右下角的行號
        group[3] = Math.max(group[3], column); // 更新右下角的列號

        dfs(grid, row - 1, column, group);
        dfs(grid, row + 1, column, group);
        dfs(grid, row, column - 1, group);
        dfs(grid, row, column + 1, group);

        return group;
    }
}
