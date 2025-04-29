package ting.leetcode.java.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    private final List<String> res = new LinkedList<>();
    private final LinkedList<String> path = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        path.addLast("" + root.val);

        if (root.left == null && root.right == null) {
            res.add(String.join("->", path));
            path.removeLast();
            return;
        }

        traverse(root.left);
        traverse(root.right);
        path.removeLast();
    }
}
