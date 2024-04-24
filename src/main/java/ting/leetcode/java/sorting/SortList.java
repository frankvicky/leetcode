package ting.leetcode.java.sorting;

import ting.leetcode.java.linkedlist.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(), pointer = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                pointer.next = left;
                left = left.next;
            } else {
                pointer.next = right;
                right = right.next;
            }
            pointer = pointer.next;
        }

        if (left != null) {
            pointer.next = left;
        }

        if (right != null) {
            pointer.next = right;
        }

        return dummy.next;
    }
}
