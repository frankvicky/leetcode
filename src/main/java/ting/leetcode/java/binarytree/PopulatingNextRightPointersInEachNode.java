package ting.leetcode.java.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Queue<Node> nodes = new LinkedList<>();
            nodes.offer(root);

            while (!nodes.isEmpty()) {
                int size = nodes.size();
                Node prevNode = null;
                for (int i = 0; i < size; i++) {
                    Node currentNode = nodes.poll();
                    if (currentNode.left != null) {
                        nodes.offer(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        nodes.offer(currentNode.right);
                    }
                    if (prevNode != null) {
                        prevNode.next = currentNode;
                    }
                    prevNode = currentNode;
                }
            }
            return root;
        }
    }

    void traverse(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        node1.next = node2;

        traverse(node1.left, node1.right);
        traverse(node1.right, node2.left);
        traverse(node2.left, node2.right);
    }
}
