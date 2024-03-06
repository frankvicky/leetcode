package ting.leetcode.java.arrays101;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') result += bfs(grid, i, j);
            }
        }
        return result;
    }

    public int bfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        //使用队列，按照“先入先出”来处理节点
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        //被访问过的节点，要标记下！
        grid[r][c] = '0';

        while (!queue.isEmpty()) {
            int[] curPos = queue.remove();

            for (int[] direction : directions) {
                int newRow = curPos[0] + direction[0];
                int newCol = curPos[1] + direction[1];

                if (newRow >= 0 && newCol >= 0 && newRow < nr && newCol < nc && grid[newRow][newCol] == '1') {
                    queue.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0'; // 同樣也要进行标记
                }
            }
        }
        return 1;
    }
}

class NumberOfIslandsDFS {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') result += dfs(grid, i, j);
            }
        }
        return result;
    }

    public int dfs(char[][] graph, int row, int column) {
        int height = graph.length;
        int width = graph[0].length;

        if (row < 0 || column < 0 || row >= height || column >= width || graph[row][column] == '0') {
            return 0;
        }

        // set visited to '0'
        graph[row][column] = '0';

        dfs(graph, row - 1, column);
        dfs(graph, row + 1, column);
        dfs(graph, row, column - 1);
        dfs(graph, row, column + 1);
        return 1;
    }

}
