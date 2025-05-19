package ting.leetcode.java.binarytree;

import ting.leetcode.java.linkedlist.ListNode;

public class LinkedListInBinaryTree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null)
            return true;

        if (root == null)
            return false;

        if (root.val == head.val)
            if (check(head, root))
                return true;

        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean check(ListNode head, TreeNode root) {
        if (head == null)
            return true;

        if (root == null)
            return false;

        if (head.val == root.val)
            return check(head.next, root.left) || check(head.next, root.right);

        return false;
    }
}
