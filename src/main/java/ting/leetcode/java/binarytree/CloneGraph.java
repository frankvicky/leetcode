package ting.leetcode.java.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // 建立原始節點與複製節點的對應關係
        HashMap<Node, Node> visited = new HashMap<>();
        LinkedList<Node> originNodeQueue = new LinkedList<>();

        // 將原始起始節點加入 queue，準備進行 dfs
        originNodeQueue.add(node);
        // 建立原始起始節點與複製起始節點的對應關係
        visited.put(node, new Node(node.val, new ArrayList<>(node.neighbors.size())));

        while (!originNodeQueue.isEmpty()) {
            Node current = originNodeQueue.pop();
            for (Node neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // 建立原始節點與複製節點的對應關係
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>(neighbor.neighbors.size())));
                    originNodeQueue.add(neighbor);
                }
                // 依據對應關係，還原鄰居關係
                Node clone = visited.get(current);
                // 上面建立完原始節點與複製節點的對應關係後，馬上還原複製節點的鄰居關係
                clone.neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }

}
