package ting.datastructure.impl;

import java.util.ArrayList;
import java.util.List;


public class WeightedDigraphInAdjacencyList {
    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private final List<Edge>[] graph;

    public WeightedDigraphInAdjacencyList(int nodeSize) {
        graph = new List[nodeSize];
        for (int i = 0; i < nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to, int weight) {
        graph[from].add(new Edge(to, weight));
    }

    public void removeEdge(int from, int to) {
        List<Edge> edges = graph[from];
        int size = edges.size();
        for (int i = 0; i < size; i++) {
            if (edges.get(i).to == to) {
                edges.remove(i);
                break;
            }
        }
    }

    public boolean hasEdge(int from, int to) {
        for (Edge edge : graph[from]) {
            if (edge.to == to) {
                return true;
            }
        }
        return false;
    }

    public int weight(int from, int to) {
        for (Edge edge : graph[from]) {
            if (edge.to == to) {
                return edge.weight;
            }
        }
        throw new IllegalArgumentException("No such edge");
    }

    public List<Edge> neighbors(int vertex) {
        return graph[vertex];
    }
}
