package ting.leetcode.java.linkedlist;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode pointer = dummy;
        int overflow = 0;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + overflow;
            } else if (l2 == null) {
                sum = l1.val + overflow;
            } else {
                sum = l2.val + overflow;
            }

            overflow = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            pointer.next = newNode;
            pointer = newNode;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (overflow != 0) {
            pointer.next = new ListNode(overflow);
        }

        return dummy.next;
    }
}
