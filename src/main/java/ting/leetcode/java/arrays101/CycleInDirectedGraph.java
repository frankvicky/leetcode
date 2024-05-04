package ting.leetcode.java.arrays101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CycleInDirectedGraph {

    private static final int VISITING = 1;
    private static final int VISITED = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 讀取節點數量
        int n = Integer.parseInt(reader.readLine());

        // 建立邊的數據結構
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        // 讀取每條邊並加到邊的數據結構中
        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            String[] splitLine = line.split(" ");
            int fromNode = Integer.parseInt(splitLine[0]);
            int toNode = Integer.parseInt(splitLine[1]);
            edges.get(fromNode).add(toNode);
        }

        // 檢查有向圖中是否存在循環
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (containsCycle(i, visited, edges)) {
                System.out.println("true");
                return;
            }
        }
        System.out.println("false");
    }

    private static boolean containsCycle(int node, int[] visited, List<List<Integer>> edges) {
        if (visited[node] == VISITING) {
            // 節點已在訪問中，存在循環
            return true;
        }

        if (visited[node] == VISITED) {
            // 節點已被訪問過，則直接返回 false
            return false;
        }

        visited[node] = VISITING;
        for (int edge : edges.get(node)) {
            if (containsCycle(edge, visited, edges)) {
                return true;
            }
        }
        visited[node] = VISITED;
        return false;
    }
}
