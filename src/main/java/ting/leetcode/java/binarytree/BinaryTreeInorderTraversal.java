package ting.leetcode.java.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayList<Integer> record = new ArrayList<>();
        record.addAll(inorderTraversal(root.left));
        record.add(root.val);
        record.addAll(inorderTraversal(root.right));
        return record;
    }
}
