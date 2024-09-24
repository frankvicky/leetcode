package ting.leetcode.java.linkedlist;

import java.util.LinkedList;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> s1 = new LinkedList<>();
        LinkedList<Integer> s2 = new LinkedList<>();

        ListNode dummy = new ListNode();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int overflow = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int sum = 0;
            if (!s1.isEmpty() && !s2.isEmpty()) {
                sum = s1.poll() + s2.poll() + overflow;
            } else if (s2.isEmpty()) {
                sum = s1.poll() + overflow;
            } else if (s1.isEmpty()) {
                sum = s2.poll() + overflow;
            }

            int value = sum % 10;
            overflow = sum / 10;

            ListNode newNode = new ListNode(value);
            ListNode next = dummy.next;
            dummy.next = newNode;
            newNode.next = next;
        }

        if (overflow != 0) {
            ListNode newNode = new ListNode(overflow);
            ListNode next = dummy.next;
            dummy.next = newNode;
            newNode.next = next;
        }

        return dummy.next;
    }
}
