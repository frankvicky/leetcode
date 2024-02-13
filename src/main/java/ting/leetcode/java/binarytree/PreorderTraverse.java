package ting.leetcode.java.binarytree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraverse {

    List<Integer> res = new LinkedList<>();

    // 返回前序遍历结果
    List<Integer> preorderTraverse(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    List<Integer> preorderTraverseRecursion(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        LinkedList<Integer> res = new LinkedList<>();
        res.add(root.val);
        res.addAll(preorderTraverseRecursion(root.left));
        res.addAll(preorderTraverseRecursion(root.right));
        return res;
    }
}
