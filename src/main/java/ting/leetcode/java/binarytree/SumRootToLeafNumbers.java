package ting.leetcode.java.binarytree;

import java.util.LinkedList;

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

class SumRootToLeafNumbersTraverse {
    private final LinkedList<String> num = new LinkedList<>();
    private final LinkedList<Integer> allNums = new LinkedList<>();
    public int sumNumbers(TreeNode root) {
        traverse(root);
        int res = 0;
        for (int n : allNums) {
            res += n;
        }
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        num.add("" + root.val);
        if (root.left == null && root.right == null) {
            allNums.add(Integer.parseInt(String.join("", num)));
            num.removeLast();
            return;
        }
        traverse(root.left);
        traverse(root.right);
        num.removeLast();
    }
}