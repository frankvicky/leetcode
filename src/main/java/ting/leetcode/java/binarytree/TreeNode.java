package ting.leetcode.java.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode arrayToTreeNode(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (index < arr.length) {
            TreeNode current = queue.poll();

            // Process the left child
            if (arr[index] != null) {
                current.left = new TreeNode(arr[index]);
                queue.offer(current.left);
            }
            index++;

            if (index >= arr.length) {
                break;
            }

            // Process the right child
            if (arr[index] != null) {
                current.right = new TreeNode(arr[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }
}
