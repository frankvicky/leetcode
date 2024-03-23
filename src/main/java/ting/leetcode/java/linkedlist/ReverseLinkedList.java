package ting.leetcode.java.linkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode current) {
        if (current == null || current.next == null) {
            return current;
        }

        ListNode nextNode = reverseList(current.next);
        current.next.next = current;
        current.next = null;
        return nextNode;
    }

    // 另一種反轉法，結就較為簡單
    public ListNode reverse(ListNode head, ListNode prev) {
        if (head == null) return prev;
        ListNode newHead = head.next;
        head.next = prev;
        return reverse(newHead, head);
    }
}
