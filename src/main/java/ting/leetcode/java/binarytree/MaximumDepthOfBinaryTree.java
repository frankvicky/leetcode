package ting.leetcode.java.binarytree;

public class MaximumDepthOfBinaryTree {
    int maxDepth = 0;
    int currentDepth = 0;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return maxDepth;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        // 前序位置
        currentDepth++;

        if (node.left == null && node.right == null) {
            maxDepth = Math.max(maxDepth, currentDepth);
        }

        traverse(node.left);
        // 中序位置
        traverse(node.right);
        // 后序位置
        currentDepth--;
    }


    int maxDepthRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 利用定义，计算左右子树的最大深度
        int leftMax = maxDepthRecursion(root.left);
        int rightMax = maxDepthRecursion(root.right);
        // 整棵树的最大深度等于左右子树的最大深度取最大值，
        // 然后再加上根节点自己

        return Math.max(leftMax, rightMax) + 1;
    }
}
