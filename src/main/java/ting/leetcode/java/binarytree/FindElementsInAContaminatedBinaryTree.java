package ting.leetcode.java.binarytree;

import java.util.HashSet;

public class FindElementsInAContaminatedBinaryTree {
    private final HashSet<Integer> cache = new HashSet<>() ;
    public FindElementsInAContaminatedBinaryTree(TreeNode root) {
        traverse(root, 0);
    }

    private void traverse(TreeNode root, int preValue) {
        if (root == null) {
            return;
        }
        root.val = preValue;
        cache.add(preValue);
        traverse(root.left, preValue * 2 + 1);
        traverse(root.right, preValue * 2 + 2);
    }

    public boolean find(int target) {
        return cache.contains(target);
    }
}
