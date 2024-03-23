package ting.leetcode.java.linkedlist;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        ListNode prev = null, next = null;

        while (secondHead != null) {
            next = secondHead.next;
            secondHead.next = prev;
            prev = secondHead;
            secondHead = next;
        }

        ListNode p1 = head;
        ListNode p2 = prev; // now prev is the head of second list due to reverse

        while (p1 != null && p2 != null) {
            ListNode p1Next = p1.next;
            p1.next = p2;
            p2 = p2.next;
            p1 = p1.next;
            p1.next = p1Next;
            p1 = p1.next;
        }
    }
}
