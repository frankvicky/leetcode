package ting.leetcode.java.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;
        int step = 0;
        Queue<TreeNode> nodes = new ArrayDeque<>();

        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();

                if ((step & 1) == 1) {
                    if ((node.val & 1) == 1) {
                        System.out.println("f1");
                        return false;
                    }

                    if (!nodes.isEmpty() && i < size - 1) {
                        if (node.val <= nodes.peek().val) {
                            return false;
                        }
                    }
                } else {
                    if ((node.val & 1) == 0) {
                        return false;
                    }

                    if (!nodes.isEmpty() && i < size - 1) {
                        if (node.val >= nodes.peek().val) {
                            return false;
                        }
                    }
                }

                if (node.left != null) {
                    nodes.offer(node.left);
                }

                if (node.right != null) {
                    nodes.offer(node.right);
                }
            }
            step++;
        }
        return true;
    }
}
