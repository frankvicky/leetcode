package ting.leetcode.java.binarytree;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode node) {
        return dfs(node, 0);
    }

    public int dfs(TreeNode node, int preSum) {
        if (node == null) {
            return 0;
        }

        int sum = preSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        } else {
            return dfs(node.left, sum) + dfs(node.right, sum);
        }
    }
}