package ting.leetcode.java.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {
    int accumulator = 0;

    public int sumOfLeftLeaves(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 0;
        }

        traverse(node);
        return accumulator;
    }

    public void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null && node.left.left == null && node.left.right == null) {
            accumulator += node.left.val;
        }

        traverse(node.left);
        traverse(node.right);
    }
}

class Solution {
    public int sumOfLeftLeaves(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int accumulator = 0;

        if (node.left != null && node.left.left == null && node.left.right == null) {
            accumulator += node.left.val;
        }

        accumulator += sumOfLeftLeaves(node.left);
        accumulator += sumOfLeftLeaves(node.right);
        return accumulator;
    }
}

class SolutionWithString {

    public int sumOfLeftLeaves(TreeNode root) {
        return traversal(root, "right");
    }

    private int traversal(TreeNode root, String symbol) {
        if (root == null) {
            return 0;
        }

        int accumulator = 0;

        if (root.left == null && root.right == null && symbol.equals("left")) {
            accumulator += root.val;
        }

        accumulator += traversal(root.left, "left");
        accumulator += traversal(root.right, "right");
        return accumulator;
    }
}

class SolutionWithBFS {
    public int sumOfLeftLeaves(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int accumulator = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null)
                    continue;

                if (poll.left != null && poll.left.left == null && poll.left.right == null) {
                    accumulator += poll.left.val;
                }

                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }

        return accumulator;
    }
}