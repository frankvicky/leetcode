package ting.leetcode.java.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VerticalOrderTraversalOfABinaryTree {
    private final List<Node> nodes = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traverse(root, 0, 0);
        nodes.sort((Node a, Node b) -> {
            if (a.col == b.col && a.row == b.row) {
                return a.node.val - b.node.val;
            } else if (a.col == b.col) {
                return a.row - b.row;
            } else return a.col - b.col;
        });

        final LinkedList<List<Integer>> res = new LinkedList<>();

        int preCol = Integer.MIN_VALUE;
        for (Node node : nodes) {
            if (node.col != preCol) {
                res.addLast(new LinkedList<>());
                preCol = node.col;
            }
            res.getLast().add(node.node.val);
        }
        return res;
    }

    private void traverse(TreeNode root, int row, int column) {
        if (root == null) {
            return;
        }

        nodes.add(new Node(row, column, root));
        traverse(root.left, row + 1, column - 1);
        traverse(root.right, row + 1, column + 1);
    }

    static class Node {
        int row;
        int col;
        TreeNode node;

        public Node(int row, int column, TreeNode node) {
            this.row = row;
            this.col = column;
            this.node = node;
        }
    }
}
