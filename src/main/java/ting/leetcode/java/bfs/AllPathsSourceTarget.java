package ting.leetcode.java.bfs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget {
//    Input: graph = [[1,2],[3],[3],[]]
//    Output: [[0,1,3],[0,2,3]]

    //    Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
//    Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]


    // 建立答案的儲存空間
    List<List<Integer>> ans = new ArrayList<>();

    // 不同路徑從源點到目標的方法
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 使用深度優先搜索
        dfs(graph, 0, new ArrayList<>());
        // 返回所有可能的路徑
        return ans;
    }

    // 深度優先搜索
    private void dfs(int[][] graph, int level, List<Integer> path) {
        // 這裡的思路是將內層元素視為 level
        // 將該級別添加到路徑中
        path.add(level);

        // 如果級別等於圖的長度-1（即達到目标），則將該路徑添加到答案中
        if (level == graph.length - 1) {
            // 我們在將path添加到 ans之前，需要先創建出一個新的列表複製(new ArrayList<>(path))
            // 這樣即使在之後path變化，添加到ans裡的這個路徑也不會被改變。
            ans.add(new ArrayList<>(path));
        } else {
            // 否則，對當前級別的所有相鄰點進行深度優先搜索
            for (int i : graph[level]) {
                dfs(graph, i, path);
            }
        }
        // 平行優先搜索完一個路徑後，刪除該路徑的最後一個級別，以供接下來的搜索使用
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},
                {3},
                {3},
                {}
        };

        new AllPathsSourceTarget().allPathsSourceTarget(graph);
    }
}
