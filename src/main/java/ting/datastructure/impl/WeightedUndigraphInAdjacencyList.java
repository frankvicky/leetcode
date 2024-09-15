package ting.datastructure.impl;

import java.util.List;

public class WeightedUndigraphInAdjacencyList {
    private final WeightedDigraphInAdjacencyList graph;

    public WeightedUndigraphInAdjacencyList(int n) {
        graph = new WeightedDigraphInAdjacencyList(n);
    }

    // 增，添加一条带权重的无向边
    public void addEdge(int from, int to, int weight) {
        graph.addEdge(from, to, weight);
        graph.addEdge(to, from, weight);
    }

    // 删，删除一条无向边
    public void removeEdge(int from, int to) {
        graph.removeEdge(from, to);
        graph.removeEdge(to, from);
    }

    // 查，判断两个节点是否相邻
    public boolean hasEdge(int from, int to) {
        return graph.hasEdge(from, to);
    }

    // 查，返回一条边的权重
    public int weight(int from, int to) {
        return graph.weight(from, to);
    }

    // 查，返回某个节点的所有邻居节点
    public List<WeightedDigraphInAdjacencyList.Edge> neighbors(int v) {
        return graph.neighbors(v);
    }
}
