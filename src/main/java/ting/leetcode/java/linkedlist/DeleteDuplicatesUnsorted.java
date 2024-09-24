package ting.leetcode.java.linkedlist;

import java.util.HashMap;

public class DeleteDuplicatesUnsorted {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        HashMap<Integer, Integer> valueToCount = new HashMap<>();
        ListNode p1 = head;
        while (p1 != null) {
            valueToCount.put(p1.val, valueToCount.getOrDefault(p1.val, 0) + 1);
            p1 = p1.next;
        }

        p1 = head;
        ListNode dummy = new ListNode();
        ListNode p2 = dummy;

        while (p1 != null) {
            if (valueToCount.get(p1.val) == 1) {
                p2.next = p1;
                p1 = p1.next;
                p2 = p2.next;
            } else {
                ListNode temp = p1;
                p1 = p1.next;
                temp.next = null;
            }
        }
        return dummy.next;
    }
}
