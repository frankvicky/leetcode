package ting.datastructure.impl;

import java.util.ArrayList;
import java.util.List;

public class WeightedDigraphInAdjacencyMatrix {
    public static class Edge {
        int to;
        int from;

        public Edge(int to, int from) {
            this.to = to;
            this.from = from;
        }
    }

    private int[][] matrix;

    public WeightedDigraphInAdjacencyMatrix(int nodeSize) {
        this.matrix = new int[nodeSize][nodeSize];
    }

    public void addEdge(int from, int to, int weight) {
        matrix[from][to] = weight;
    }

    public void removeEdge(int from, int to) {
        matrix[from][to] = 0;
    }

    public boolean hasEdge(int from, int to) {
        return matrix[from][to] != 0;
    }

    public List<Edge> neighbors(int vertex) {
        List<Edge> edges = new ArrayList<>();
        int length = matrix[vertex].length;

        for (int i = 0; i < length; i++) {
            int[] edgesOfVertex = matrix[vertex];
            if (edgesOfVertex[i] > 0) {
                edges.add(new Edge(i, edgesOfVertex[i]));
            }
        }

        return edges;
    }
}
