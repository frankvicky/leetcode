package ting.leetcode.java.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        ArrayList<Integer> record = new ArrayList<>();
        record.add(root.val);
        record.addAll(preorderTraversal(root.left));
        record.addAll(preorderTraversal(root.right));
        return record;
    }
}
